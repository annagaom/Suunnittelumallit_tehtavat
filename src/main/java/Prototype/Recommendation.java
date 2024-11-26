package Prototype;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {
    private String targetAudience;
    private List<Book> books;

    // Constructor
    public Recommendation(String targetAudience, List<Book> books) {
        this.targetAudience = targetAudience;
        this.books = books != null ? books : new ArrayList<>();
    }

    // Getter and Setter methods
    public String getTargetAudience() {
        return targetAudience;
    }

    public List<Book> getBooks() {
        return books;
    }

    // Method to add a book to the recommendation
    public void addBook(Book book) {

        this.books.add(book);
    }

    // Method to remove a book from the recommendation
    public void removeBook(Book book) {
        this.books.remove(book);
    }

    // Method to modify the target audience
    public void modifyTargetAudience(String newAudience) {
        this.targetAudience = newAudience;
    }

    // Clone method (Prototype Pattern)
    @Override
    public Recommendation clone() {
        try {
            // Create a shallow copy of the recommendation
            Recommendation cloned = (Recommendation) super.clone();
            // Create a deep copy of the list of books
            cloned.books = new ArrayList<>();
            for (Book book : this.books) {
                cloned.books.add(book.clone());  // Clone each Book object
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Recommendation{" +
                "targetAudience='" + targetAudience + '\'' +
                ", books=" + books +
                '}';
    }
}
