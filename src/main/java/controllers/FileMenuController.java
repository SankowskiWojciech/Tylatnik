package controllers;

import controllers.AbstractController;
import controllers.TextAreaController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import logic.reading.Reader;
import logic.writing.Writer;

import java.io.File;
import java.util.List;

public class FileMenuController extends AbstractController<MenuItem> {

    private MenuBar menuBar;
    private Menu fileMenu;
    private File file;
    private StringProperty fileName = new SimpleStringProperty(this, "fileNameProperty", "Untitled");
    private TextAreaController textAreaController;
    private Reader reader;
    private Writer writer;

    private MenuItem newFileItem;
    private MenuItem openFileItem;
    private MenuItem saveFileItem;
    private MenuItem saveFileAsItem;

    public File getFile() {
        return file;
    }

    public void setMenuBar(MenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setTextAreaController(TextAreaController textAreaController) {
        this.textAreaController = textAreaController;
    }

    public void setFileMenu(Menu fileMenu) {
        this.fileMenu = fileMenu;
        List<MenuItem> list = fileMenu.getItems();
        newFileItem = getItem(list, "newFileItem");
        newFileItem.setOnAction(e -> newFileHandler());
        openFileItem = getItem(list, "openFileItem");
        openFileItem.setOnAction(e -> openFileHandler());
        saveFileItem = getItem(list, "saveFileItem");
        saveFileItem.setDisable(true);
        saveFileItem.setOnAction(e -> saveFileHandler());
        saveFileAsItem = getItem(list, "saveFileAsItem");
        saveFileAsItem.setOnAction(e -> saveFileAsHandler());
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public String getFileName() {
        return fileName.get();
    }

    public StringProperty getFileNameProperty() {
        return fileName;
    }

    private void openFileHandler() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("*.txt", "*.txt"),
                new FileChooser.ExtensionFilter("All types", "*.*")
        );
        File openFile = fileChooser.showOpenDialog(menuBar.getScene().getWindow());
        if(openFile != null) {
            file = openFile;
            fileName.setValue(file.getName());
            textAreaController.setText(reader.readFile(file));
            if(saveFileItem.isDisable())
                saveFileItem.setDisable(false);
        }
    }

    private void newFileHandler() {
        file = null;
        textAreaController.setText("");
        if(!saveFileItem.isDisable())
            saveFileItem.setDisable(true);
        fileName.setValue("Untitled");
    }

    private void saveFileHandler() {
        if(file != null)
            writer.writeFile(file, textAreaController.getText());
    }

    private void saveFileAsHandler() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save as");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("*.txt", "*.txt"),
                new FileChooser.ExtensionFilter("All types", "*.*")
        );
        File saveFile = fileChooser.showSaveDialog(menuBar.getScene().getWindow());
        if(saveFile != null) {
            file = saveFile;
            fileName.setValue(file.getName());
            writer.writeFile(file, textAreaController.getText());
        }
    }
}
