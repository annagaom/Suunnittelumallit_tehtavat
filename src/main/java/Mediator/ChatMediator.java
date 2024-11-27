package Mediator;

public interface ChatMediator {
    void sendMessage(String message, String sender, String recipient);
    void addClient(ChatClient client);
}
