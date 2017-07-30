package main;

import controllers.*;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import logic.dataStorage.DataStorageInterface;
import logic.dataStorage.DataStorage;
import logic.patternSearching.BoyerMooreAlgorithm;
import logic.reading.Reader;
import logic.reading.TextFileReader;
import logic.writing.TextFileWriter;
import logic.writing.Writer;
import view.GUI;

import java.io.File;
import java.util.Observer;

public class Main extends Application {

    private Reader reader;
    private Writer writer;

    //logic
    private File file;
    private StringProperty stageTitle = new SimpleStringProperty(this, "fileNameProperty", "Untitled - Tylatnik");
    private DataStorageInterface dataStorage = new DataStorage();

    //view
    private GUI gui;
    private BorderPane borderPane;

    //controllers
    private GUIController guiController;
    private TextAreaController textAreaController;
    private FileMenuController fileMenuController;
    private ToolbarController toolbarController;

    @Override
    public void start(Stage primaryStage) throws Exception {
        reader = new TextFileReader();
        writer = new TextFileWriter();

        //GUI view
        gui = new GUI();
        borderPane = gui.getBorderPane();
        primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("/los.jpg")));
        primaryStage.setTitle(stageTitle.getValue());
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();

        textAreaController = new TextAreaController();
        textAreaController.setTextArea(gui.getTextArea());
        textAreaController.registerObserver((Observer) dataStorage);
        textAreaController.setSearchingAlgorithm(new BoyerMooreAlgorithm());

        fileMenuController = new FileMenuController();
        fileMenuController.setMenuBar(gui.getMenuBar());
        fileMenuController.setFileMenu(gui.getFileMenu());
        fileMenuController.setTextAreaController(textAreaController);
        fileMenuController.setFile(file);
        fileMenuController.setReader(reader);
        fileMenuController.setWriter(writer);
        stageTitle.bind(fileMenuController.getFileNameProperty());
        //stage title is the same as current file or Untitled when there's no file
        stageTitle.addListener((observable, oldValue, newValue) -> primaryStage.setTitle(stageTitle.getValue() + " - Tylatnik"));

        toolbarController = new ToolbarController();
        toolbarController.setTextAreaController(textAreaController);
        toolbarController.setSearchingController(new SearchingController(new BoyerMooreAlgorithm()));
        toolbarController.setToolBar(gui.getToolbar());
        //Ctrl+F shortcut for searching phrases
        primaryStage.getScene().addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            final KeyCombination keyCombination = new KeyCodeCombination(KeyCode.F, KeyCombination.CONTROL_DOWN);
            @Override
            public void handle(KeyEvent event) {
                if (keyCombination.match(event)) {
                    toolbarController.getSearchField().requestFocus();
                    event.consume();
                }
            }
        });

        guiController = new GUIController();
        guiController.setDataStorage(dataStorage);
        guiController.setReader(reader);
        guiController.setWriter(writer);
        guiController.setTextAreaController(textAreaController);
    }

    public static void main(String[] args) {
        launch(args);
    }

}


