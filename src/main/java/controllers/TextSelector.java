package controllers;

import java.util.List;

class TextSelector {

    private TextAreaController textAreaController;
    private List<Integer> indexes;
    private int lengthOfPatterm;
    private int currentSelection;

    public void setTextAreaController(TextAreaController textAreaController) {
        this.textAreaController = textAreaController;
    }

    public void selectFirst() {
        currentSelection = 0;
        textAreaController.setSelected(indexes.get(currentSelection), indexes.get(currentSelection) + lengthOfPatterm);
    }

    public void setIndexes(List<Integer> indexes) {
        this.indexes = indexes;
    }

    public void setLengthOfPatterm(int lengthOfPatterm) {
        this.lengthOfPatterm = lengthOfPatterm;
    }

    public void selectPrevious() {
        if(indexes.size() < 2)
            return;
        if(currentSelection == 0) {
            currentSelection = indexes.size() - 1;
        } else {
            currentSelection--;
        }
        textAreaController.setSelected(indexes.get(currentSelection), indexes.get(currentSelection) + lengthOfPatterm);
    }

    public void selectNext() {
        if(indexes.size() < 2)
            return;
        if(currentSelection == indexes.size() - 1) {
            currentSelection = 0;
        } else {
            currentSelection++;
        }
        textAreaController.setSelected(indexes.get(currentSelection), indexes.get(currentSelection) + lengthOfPatterm);
    }
}
