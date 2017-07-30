package view;

import javafx.geometry.Orientation;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

class ToolbarSection {

    private ToolBar toolBar;

    ToolbarSection() {
        toolBar = setToolBar();
    }

    ToolBar getToolBar() {
        return toolBar;
    }

    private ToolBar setToolBar() {
        ToolBar toolBar = new ToolBar();
        toolBar.setId("toolBar");
        toolBar.getItems().addAll(addToggleButtons());
        toolBar.getItems().addAll(addComboBox());
        toolBar.getItems().add(addSeparator("separator1"));
        toolBar.getItems().add(addTextField());
        toolBar.getItems().add(addSeparator("separator2"));
        toolBar.getItems().add(addArrow("leftArrow", "leftArrow"));
        toolBar.getItems().add(addArrow("rightArrow", "rightArrow"));
        toolBar.getItems().add(addLabel("Found: ", "label1"));
        toolBar.getItems().add(addLabel("", "numOfFoundLabel"));
        return toolBar;
    }

    private List<ToggleButton> addToggleButtons() {
        List<ToggleButton> list = new ArrayList<>();
        list.add(addToggleButton("", "boldButton"));
        list.add(addToggleButton("", "italicsButton"));
        list.add(addToggleButton("", "upperLettersButton"));
        list.add(addToggleButton("", "lowerLettersButton"));
        return list;
    }

    private ToggleButton addToggleButton(String name, String id) {
        ToggleButton toggleButton = new ToggleButton(name);
        toggleButton.setId(id);
        toggleButton.getStylesheets().add(this.getClass().getResource("/css/toggleButtons.css").toExternalForm());
        return toggleButton;
    }

    //combo box for setting font size
    private ComboBox addComboBox() {
        ComboBox fontSizeComboBox = new ComboBox();
        fontSizeComboBox.setId("fontSize");
        fontSizeComboBox.setPrefWidth(75);
        fontSizeComboBox.getItems().addAll("4", "6", "8", "10", "12", "14", "16", "18", "20", "24", "28", "36", "48", "56", "64", "72");
        fontSizeComboBox.setEditable(true);
        fontSizeComboBox.setValue(12);
        return fontSizeComboBox;
    }

    //text field for searching phrases
    private TextField addTextField() {
        TextField searchField = new TextField();
        searchField.setId("searchField");
        searchField.setPromptText("Search Ctrl+F");
        searchField.setPrefWidth(200);
        return searchField;
    }

    private Separator addSeparator(String id) {
        Separator separator = new Separator(Orientation.VERTICAL);
        separator.setId(id);
        return separator;
    }

    //left and right arrow to switch between found phrases
    private Button addArrow(String name, String id) {
        Button arrow = new Button(name);
        arrow.setId(id);
        arrow.getStylesheets().add(this.getClass().getResource("/css/arrows.css").toExternalForm());
        return arrow;
    }

    //label for information about number of found phrases
    private Label addLabel(String text, String id) {
        Label label = new Label();
        label.setText(text);
        label.setId(id);
        return label;
    }
}
