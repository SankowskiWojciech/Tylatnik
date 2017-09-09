package controllers;

import logic.dataStorage.DataStorageInterface;
import logic.reading.Reader;
import logic.writing.Writer;

import java.io.File;

public class GUIController {

    private TextAreaController textAreaController;

    private Reader reader;
    private Writer writer;
    private DataStorageInterface dataStorage;
    private File file;

    public void setDataStorage(DataStorageInterface dataStorage) {
        this.dataStorage = dataStorage;
    }

    public void setTextAreaController(TextAreaController textAreaController) {
        this.textAreaController = textAreaController;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }
}
