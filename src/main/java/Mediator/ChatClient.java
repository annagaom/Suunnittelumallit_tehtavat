package Mediator;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;

public class ChatClient {
    private String username;
    private ChatMediator mediator;
    private TextArea messageArea;
    private TextField messageField;
    private ChoiceBox<String> recipientChoiceBox;

    public ChatClient(String username, ChatMediator mediator, TextArea messageArea, TextField messageField, ChoiceBox<String> recipientChoiceBox) {
        this.username = username;
        this.mediator = mediator;
        this.messageArea = messageArea;
        this.messageField = messageField;
        this.recipientChoiceBox = recipientChoiceBox;

        mediator.addClient(this);
    }

    public String getUsername() {
        return username;
    }

    public void sendMessage() {
        String recipient = recipientChoiceBox.getValue();
        String message = messageField.getText();

        if (recipient == null || message.isEmpty()) {
            showError("Recipient and message cannot be empty!");
            return;
        }

        mediator.sendMessage(message, username, recipient);
        messageField.clear();
    }

    public void receiveMessage(String message, String sender) {
        messageArea.appendText(sender + ": " + message + "\n");
    }

    private void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
