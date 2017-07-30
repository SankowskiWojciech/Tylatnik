package view;

import javafx.scene.control.TextArea;

class TextAreaView {

    private TextArea textArea;

    TextAreaView() {
        textArea = setTextArea();
    }

    TextArea getTextArea() {
        return textArea;
    }

    private TextArea setTextArea() {
        TextArea textArea = new TextArea();
        textArea.setId("textArea");
        textArea.getStylesheets().add(this.getClass().getResource("/css/textArea.css").toExternalForm());
        return textArea;
    }
}
