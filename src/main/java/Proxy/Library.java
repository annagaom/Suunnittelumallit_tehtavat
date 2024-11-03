package Proxy;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<String, Document> documents = new HashMap<>();

    public void addDocument(Document document) {
        documents.put(document.getIdentifier(), document);
    }

    public Document getDocument(String identifier) {
        return documents.get(identifier);
    }

    public void addProtectedDocument(String identifier, String creationDate, String content) {
        RealDocument realDocument = new RealDocument(identifier, creationDate, content);
        DocumentProxy documentProxy = new DocumentProxy(realDocument);
        addDocument(documentProxy);
    }

    public void addUnprotectedDocument(String identifier, String creationDate, String content) {
        RealDocument realDocument = new RealDocument(identifier, creationDate, content);
        addDocument(realDocument);
    }
}
