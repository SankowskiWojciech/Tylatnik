package controllers;

import javafx.scene.Node;
import javafx.scene.control.*;

import java.util.List;

public class ToolbarController extends AbstractController<Node> {
    private TextAreaController textAreaController;
    private SearchingController searchingController;
    private ToolBar toolBar;
    private TextSelector textSelector;

    private ToggleButton boldButton;
    private ToggleButton italicsButton;
    private ToggleButton emphasisButton;
    private ToggleButton upperLettersButton;
    private ToggleButton lowerLettersButton;
    private ComboBox fontSizeComboBox;
    private TextField searchField;
    private Button leftArrow;
    private Button rightArrow;
    private Label numOfFoundLabel;

    public void setToolBar(ToolBar toolBar) {
        this.toolBar = toolBar;
        textSelector = new TextSelector();
        textSelector.setTextAreaController(textAreaController);
        List<Node> list = toolBar.getItems();
        boldButton = (ToggleButton) getItem(list, "boldButton");
        boldButton.setOnAction(e -> textAreaController.setBold());
        italicsButton = (ToggleButton) getItem(list, "italicsButton");
        italicsButton.setOnAction(e -> textAreaController.setItalics());
        upperLettersButton = (ToggleButton) getItem(list, "upperLettersButton");
        upperLettersButton.setOnAction(e -> textAreaController.setUpperLetters());
        lowerLettersButton = (ToggleButton) getItem(list, "lowerLettersButton");
        lowerLettersButton.setOnAction(e -> textAreaController.setLowerLetters());
        fontSizeComboBox = (ComboBox) getItem(list, "fontSize");
        fontSizeComboBox.valueProperty().addListener((observable, oldValue, newValue) ->
                textAreaController.setFontSize(Integer.valueOf((String)newValue)));
        searchField = (TextField) getItem(list, "searchField");
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
                List<Integer> indexes = searchingController.search(textAreaController.getText().toLowerCase(), newValue.toLowerCase());
                if(indexes!= null) {
                    textSelector.setIndexes(indexes);
                    textSelector.setLengthOfPatterm(newValue.length());
                    textSelector.selectFirst();
                }
        });
        leftArrow = (Button) getItem(list, "leftArrow");
        leftArrow.setDisable(true);
        leftArrow.setOnAction(e -> textSelector.selectPrevious());
        rightArrow = (Button) getItem(list, "rightArrow");
        rightArrow.setDisable(true);
        rightArrow.setOnAction(e -> textSelector.selectNext());
        numOfFoundLabel = (Label) getItem(list, "numOfFoundLabel");
        numOfFoundLabel.textProperty().bind(searchingController.getNumberOfFoundProperty());
        numOfFoundLabel.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.equals("0") || newValue.equals("")) {
                leftArrow.setDisable(true);
                rightArrow.setDisable(true);
            } else {
                leftArrow.setDisable(false);
                rightArrow.setDisable(false);
            }
        });
    }

    public ToolBar getToolBar() {
        return toolBar;
    }

    public TextAreaController getTextAreaController() {
        return textAreaController;
    }

    public void setTextAreaController(TextAreaController textAreaController) {
        this.textAreaController = textAreaController;
    }

    public void setSearchingController(SearchingController searchingController) {
        this.searchingController = searchingController;
    }

    public TextField getSearchField() {
        return searchField;
    }
}
