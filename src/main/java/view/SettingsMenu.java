package view;

import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;

class SettingsMenu {

    private Menu menu;

    SettingsMenu() {
        menu = setSettingsMenu();
    }

    Menu getSettingsMenu() {
        return menu;
    }

    private Menu setSettingsMenu() {
        Menu menu = new Menu("Settings");
        menu.setId("settingsMenu");
        menu.getItems().addAll(new CheckMenuItem("Show toolbox"), new CheckMenuItem("Wrap text"));
        return menu;
    }
}
