package controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import logic.patternSearching.SearchingAlgorithm;

import java.util.List;

public class SearchingController {

    private StringProperty numberOfFound;
    private SearchingAlgorithm searchingAlgorithm;

    public SearchingController(SearchingAlgorithm searchingAlgorithm) {
        this.searchingAlgorithm = searchingAlgorithm;
        numberOfFound = new SimpleStringProperty();
    }

    public List<Integer> search(String text, String pattern) {
        if(!pattern.equals("")) {
            List<Integer> indexes = searchingAlgorithm.search(text, pattern);
            if(indexes != null) {
                numberOfFound.set(String.valueOf(indexes.size()));
                return indexes;
            } else {
                numberOfFound.set("0");
                return null;
            }
        } else {
            numberOfFound.set("");
            return null;
        }
    }

    public int getNumberOfFound() {
        return Integer.valueOf(numberOfFound.get());
    }

    public StringProperty getNumberOfFoundProperty() {
        return numberOfFound;
    }

}
