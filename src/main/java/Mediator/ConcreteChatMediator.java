package Mediator;

import java.util.HashMap;
import java.util.Map;

public class ConcreteChatMediator implements ChatMediator {
    private Map<String, ChatClient> clients = new HashMap<>();

    @Override
    public void sendMessage(String message, String sender, String recipient) {
        ChatClient recipientClient = clients.get(recipient);
        if (recipientClient != null) {
            recipientClient.receiveMessage(message, sender);
        }
    }

    @Override
    public void addClient(ChatClient client) {
        clients.put(client.getUsername(), client);
    }
}
