package view;

import javafx.collections.ObservableList;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class GUI {
    private BorderPane borderPane;
    private VBox topSection;
    private MenuSection menuSection;
    private ToolbarSection toolbarSection;
    private TextAreaView textAreaView;

    public GUI() {
        menuSection = new MenuSection();
        textAreaView = new TextAreaView();
        toolbarSection = new ToolbarSection();
        borderPane = setBorderPane();
    }

    public BorderPane getBorderPane() {
        return borderPane;
    }

    public MenuBar getMenuBar() {
        return menuSection.getMenuBar();
    }

    public Menu getFileMenu() {
        return getMenu(menuSection.getMenuBar().getMenus(), "fileMenu");
    }

    public Menu getEditMenu() {
        return getMenu(menuSection.getMenuBar().getMenus(), "editMenu");
    }

    public Menu SettingsMenu() {
        return getMenu(menuSection.getMenuBar().getMenus(), "settingsMenu");
    }

    public ToolBar getToolbar() {
        return toolbarSection.getToolBar();
    }

    public TextArea getTextArea() {
        return textAreaView.getTextArea();
    }

    private BorderPane setBorderPane() {
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(1280, 720);
        topSection = new VBox();
        topSection.setId("top");
        topSection.getChildren().addAll(menuSection.getMenuBar(), toolbarSection.getToolBar());
        borderPane.setTop(topSection);
        borderPane.setCenter(textAreaView.getTextArea());
        return borderPane;
    }

    private Menu getMenu(ObservableList<Menu> list, String id) {
        for(Menu menu : list)
            if(menu.getId().equals(id))
                return menu;
        return null;
    }
}