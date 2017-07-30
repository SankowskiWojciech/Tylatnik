package view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

class EditMenu {

    private Menu menu;

    EditMenu() {
        menu = setEditMenu();
    }

    Menu getEditMenu() {
        return menu;
    }

    private Menu setEditMenu() {
        Menu menu = new Menu("Edit");
        menu.setId("editMenu");
        menu.getItems().addAll(
                addMenuItem("Undo Ctrl+Z", "undoItem"),
                addMenuItem("Redo Ctrl+Y", "redoItem"),
                new SeparatorMenuItem(),
                addMenuItem("Copy Ctrl+C", "copyItem"),
                addMenuItem("Cut Ctrl+X", "cutItem"),
                addMenuItem("Paste Ctrl+V", "pasteItem"),
                addMenuItem("Mark All Ctrl+A", "markAllItem"),
                new SeparatorMenuItem(),
                addMenuItem("To Upper Ctrl+Shift+U", "toUpperItem"),
                addMenuItem("To Lower Ctrl+U", "toLowerItem"),
                new SeparatorMenuItem(),
                addMenuItem("Find Ctrl+F", "findItem")
        );
        return menu;
    }

    private MenuItem addMenuItem(String name, String id) {
        MenuItem menuItem = new MenuItem(name);
        menuItem.setId(id);
        return menuItem;
    }
}
