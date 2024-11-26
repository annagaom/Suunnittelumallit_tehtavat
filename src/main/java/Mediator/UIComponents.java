package Mediator;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UIComponents {
    private TextArea messageArea;
    private TextField messageField;
    private ChoiceBox<String> recipientChoiceBox;

    public UIComponents(TextArea messageArea, TextField messageField, ChoiceBox<String> recipientChoiceBox) {
        this.messageArea = messageArea;
        this.messageField = messageField;
        this.recipientChoiceBox = recipientChoiceBox;
    }

    public TextArea getMessageArea() {
        return messageArea;
    }

    public TextField getMessageField() {
        return messageField;
    }

    public ChoiceBox<String> getRecipientChoiceBox() {
        return recipientChoiceBox;
    }
}
