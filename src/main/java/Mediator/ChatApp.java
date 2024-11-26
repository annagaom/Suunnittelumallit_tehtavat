package Mediator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class ChatApp extends Application {
    private ConcreteChatMediator mediator = new ConcreteChatMediator();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create and set up the first client (User 1)
        Stage user1Stage = createClientStage("User 1");
        ChatClient user1 = createChatClient("User 1", user1Stage);
        user1Stage.show();

        // Create and set up the second client (User 2)
        Stage user2Stage = createClientStage("User 2");
        ChatClient user2 = createChatClient("User 2", user2Stage);
        user2Stage.show();

        // Create and set up the third client (User 3)
        Stage user3Stage = createClientStage("User 3");
        ChatClient user3 = createChatClient("User 3", user3Stage);
        user3Stage.show();
    }

    // Helper function to create a chat client
    private ChatClient createChatClient(String username, Stage stage) {
        UIComponents components = (UIComponents) stage.getUserData();
        return new ChatClient(username, mediator, components.getMessageArea(), components.getMessageField(), components.getRecipientChoiceBox());
    }

    // Helper function to create client stage
    private Stage createClientStage(String username) {
        TextArea messageArea = new TextArea();
        messageArea.setEditable(false);
        TextField messageField = new TextField();

        // ChoiceBox to select the recipient
        ChoiceBox<String> recipientChoiceBox = new ChoiceBox<>();
        recipientChoiceBox.getItems().addAll("User 1", "User 2", "User 3");
        recipientChoiceBox.setValue("User 1");  // Default value

        Button sendButton = new Button("Send");
        sendButton.setOnAction(e -> {
            ChatClient client = new ChatClient(username, mediator, messageArea, messageField, recipientChoiceBox);
            client.sendMessage();
        });

        Label messageLabel = new Label("Enter Message:");
        Label recipientLabel = new Label("Recipient:");

        VBox layout = new VBox(10, messageArea, messageLabel, messageField, recipientLabel, recipientChoiceBox, sendButton);

        // Add 20px margin to the whole VBox layout (padding for the entire VBox)
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 400, 400);

        Stage clientStage = new Stage();
        clientStage.setTitle("Chat - " + username);
        clientStage.setScene(scene);

        // Store the components in a UIComponents object
        clientStage.setUserData(new UIComponents(messageArea, messageField, recipientChoiceBox));

        return clientStage;
    }
}
