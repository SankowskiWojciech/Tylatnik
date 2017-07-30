package view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

class FileMenu {

    private Menu menu;

    FileMenu() {
        menu = setFileMenu();
    }

    Menu getFileMenu() {
        return menu;
    }

    private Menu setFileMenu() {
        Menu menu = new Menu("File");
        menu.setId("fileMenu");
        menu.getItems().addAll(
                addMenuItem("New", "newFileItem", new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN)),
                addMenuItem("Open", "openFileItem", new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN)),
                addMenuItem("Save", "saveFileItem", new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN)),
                addMenuItem("Save As...", "saveFileAsItem", new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN))
        );
        return menu;
    }

    private MenuItem addMenuItem(String name, String id, KeyCodeCombination keyCodeCombination) {
        MenuItem menuItem = new MenuItem(name);
        menuItem.setId(id);
        menuItem.setAccelerator(keyCodeCombination);
        return menuItem;
    }
}
