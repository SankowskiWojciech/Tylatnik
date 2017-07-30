package view;

import javafx.scene.control.MenuBar;

class MenuSection{
    private MenuBar menuBar;

    MenuSection() {
        menuBar = setMenuBar();
        menuBar.getMenus().addAll(new FileMenu().getFileMenu(), new EditMenu().getEditMenu(), new SettingsMenu().getSettingsMenu());
    }

    MenuBar getMenuBar() {
        return menuBar;
    }

    private MenuBar setMenuBar() {
        MenuBar menuBar = new MenuBar();
        menuBar.setId("menu");
        return menuBar;
    }
}
