package Proxy;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        AccessControlService accessControl = AccessControlService.getInstance();

        // Create users
        User alice = new User("alice");
        User bob = new User("bob");

        // Add unprotected document
        library.addUnprotectedDocument("doc1", "2023-01-01", "Public content");

        // Add protected document and set access for 'alice'
        library.addProtectedDocument("doc2", "2023-02-01", "Protected content");
        accessControl.allowAccess("doc2", "alice");

        // Access documents
        try {
            // Unprotected document access
            Document doc1 = library.getDocument("doc1");
            System.out.println("Doc1 Content: " + doc1.getContent(bob)); // Should work for anyone

            // Protected document access
            Document doc2 = library.getDocument("doc2");
            System.out.println("Doc2 Content (Alice): " + doc2.getContent(alice)); // Should succeed

            System.out.println("Doc2 Content (Bob): " + doc2.getContent(bob)); // Should throw exception
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}
