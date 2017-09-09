package controllers;
import javafx.scene.control.TextArea;
import logic.patternSearching.SearchingAlgorithm;

import java.util.*;

public class TextAreaController extends Observable {

    private TextArea textArea;
    private List<Observer> observers = new ArrayList<>();

    private boolean isBold = false;
    private boolean isItalics = false;
    private boolean isUpper = false;
    private boolean isLower = false;
    private int fontSize;

    private String copy;

    private SearchingAlgorithm searchingAlgorithm;

    public void setText(String value) {
        textArea.setText(value);
    }

    public String getText() {
        return textArea.getText();
    }

    public void setBold() {
        if(!isBold) {
            isBold = true;
            textArea.setStyle(changeStyle(textArea.getStyle(), "-fx-font-weight: normal;", "-fx-font-weight: bold;"));
        } else {
            isBold = false;
            textArea.setStyle(changeStyle(textArea.getStyle(), "-fx-font-weight: bold;", "-fx-font-weight: normal;"));
        }
    }

    public void setItalics() {
        if(!isItalics) {
            isItalics = true;
            textArea.setStyle(changeStyle(textArea.getStyle(), "-fx-font-style: normal;", "-fx-font-style: italic;"));
        } else {
            isItalics = false;
            textArea.setStyle(changeStyle(textArea.getStyle(), "-fx-font-style: italic;", "-fx-font-style: normal;"));
        }
    }

    public void setUpperLetters() {
        if(!isUpper) {
            isUpper = true;
            copy = getText();
            setText(getText().toUpperCase());
        } else {
            isUpper = false;
            setText(copy);
        }
    }

    public void setLowerLetters() {
        if(!isLower) {
            isLower = true;
            copy = getText();
            setText(getText().toLowerCase());
        } else {
            isLower = false;
            setText(copy);
        }
    }

    public void setFontSize(int fontSize) {
        textArea.setStyle(changeStyle(textArea.getStyle(), "-fx-font-size: " + this.fontSize + "px;", "-fx-font-size: " + fontSize + "px;"));
    }

    public void setSelected(int begin, int end) {
        textArea.positionCaret(begin);
        textArea.selectPositionCaret(end);
    }

    public void setTextArea(TextArea textArea) {
        this.textArea = textArea;
        textArea.setText("");
        textArea.textProperty().addListener(((observable, oldValue, newValue) -> notifyObservers(newValue)));
    }

    public void notifyObservers(String newData) {
        for(Observer observer : observers)
            observer.update(this, newData);
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void setSearchingAlgorithm(SearchingAlgorithm searchingAlgorithm) {
        this.searchingAlgorithm = searchingAlgorithm;
    }

    private String changeStyle(String currentStyle, String property, String newStyle) {
        if(currentStyle.contains(property))
            currentStyle = currentStyle.replace(property, newStyle);
        else
            currentStyle = currentStyle.concat(newStyle);
        return currentStyle;
    }

}
