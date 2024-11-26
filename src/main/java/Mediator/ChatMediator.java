package Mediator;

import java.util.HashMap;
import java.util.Map;

public interface ChatMediator {
    void sendMessage(String message, String sender, String recipient);
    void addClient(ChatClient client);
}
