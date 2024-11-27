package Mediator;

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
        String message = messageField.getText();
        String recipient = recipientChoiceBox.getValue();
        String sender = username;

        if (!message.isEmpty()) {
            // Display the message in the sender's TextArea immediately
            messageArea.setScrollTop(Double.MAX_VALUE); // Scroll to the bottom

            // Send the message to the mediator, which will route it to the recipient
            mediator.sendMessage(sender, recipient, message);
            messageField.clear();
        }
    }

    public void receiveMessage(String sender, String message) {
        messageArea.setWrapText(true); // Enable text wrapping
        String formattedMessage = sender + ": " + message;

        // Approximate width of one character in pixels (adjust as needed)
        double charWidth = 7;
        double messageAreaWidth = messageArea.getWidth();
        int totalCharsPerLine = (int) (messageAreaWidth / charWidth); // Calculate total characters per line

        // Indent the first line
        String indentedMessage = formattedMessage;

        // Split the message into lines if it exceeds the width
        StringBuilder wrappedMessage = new StringBuilder();
        int currentLineLength = 0;

        for (String word : indentedMessage.split(" ")) {
            // Add the word and a space
            currentLineLength += word.length() + 1;

            // If the current line exceeds the total characters per line
            if (currentLineLength > totalCharsPerLine) {
                currentLineLength = word.length() + 1; // Reset line length with the current word
            }

            wrappedMessage.append(word).append(" "); // Append the word
        }

        // Append the wrapped and aligned message
        messageArea.appendText(wrappedMessage.toString().trim() + "\n");

        // Scroll to the bottom of the message area
        messageArea.setScrollTop(Double.MAX_VALUE);
    }
}