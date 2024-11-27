package Mediator;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;

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
        String message = messageField.getText();
        String recipient = recipientChoiceBox.getValue();
        String sender = username;

        if (!message.isEmpty()) {
            // Display the message in the sender's TextArea immediately
           // messageArea.appendText(sender + " -> " + recipient + ": " + message + "\n");
            messageArea.setScrollTop(Double.MAX_VALUE); // Scroll to the bottom

            // Send the message to the mediator, which will route it to the recipient
            mediator.sendMessage(sender, recipient, message);

            messageField.clear(); // Clear the message input field after sending
        }
    }


    public void receiveMessage(String sender, String message) {
        // Create the formatted message with sender and message
        String formattedMessage = sender + ": " + message + "\n";

        // Check if the current client is the recipient
        if (sender.equals(username)) {
            // Align the sender's messages to the left
            messageArea.appendText(formattedMessage);  // Just append the text as normal
        } else {
            // Simulate right alignment for the recipient
            String indentedMessage = formattedMessage;  // Add space to simulate right alignment

            messageArea.appendText(indentedMessage);  // Append the indented message
        }

        // Scroll to the bottom of the message area
        messageArea.setScrollTop(Double.MAX_VALUE);
    }


    private void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}