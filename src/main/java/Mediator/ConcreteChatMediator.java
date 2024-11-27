package Mediator;

import java.util.HashMap;
import java.util.Map;

public class ConcreteChatMediator implements ChatMediator {
    private Map<String, ChatClient> clients = new HashMap<>();

    @Override
    public void sendMessage(String sender, String recipient, String message) {
        // First, send the message to the sender's own window
        if (clients.containsKey(sender)) {
            clients.get(sender).receiveMessage(sender, message);  // Display to sender
        }

        // Then, send the message to the recipient's window
        if (clients.containsKey(recipient)) {
            clients.get(recipient).receiveMessage(sender, message);  // Display to recipient
        }
    }

    @Override
    public void addClient(ChatClient client) {
        clients.put(client.getUsername(), client);
    }

}