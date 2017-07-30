package logic.dataStorage;

import java.util.Observable;
import java.util.Observer;

public class DataStorage implements Observer, DataStorageInterface{
    private String text;

    public DataStorage() {
        text = new String();
    }

    public DataStorage(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void update(Observable observable, Object o) {
        text = ((String)o);
    }
}
