package Proxy;

public interface Document {
    String getIdentifier();
    String getCreationDate();
    String getContent(User user) throws AccessDeniedException;
}
