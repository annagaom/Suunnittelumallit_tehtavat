package Prototype;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create some Book objects
        Book book1 = new Book("George Orwell", "1984", "Dystopian", 1949, "Young Adults");
        Book book2 = new Book("J.K. Rowling", "Harry Potter and the Philosopher's Stone", "Fantasy", 1997, "Young Adults");
        Book book3 = new Book("J.R.R. Tolkien", "The Hobbit", "Fantasy", 1937, "Child");

        List<Book> books = new ArrayList<>(Arrays.asList(book1, book2, book3));
        List<Book> booksForYoungAdults = new ArrayList<>(Arrays.asList(book1, book2));

        Recommendation rec1 = new Recommendation("Young Adults", booksForYoungAdults);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBook Recommendation System");
            System.out.println("1. View Recommendation");
            System.out.println("2. Clone a Recommendation");
            System.out.println("3. Modify the target audience of Recommendation");
            System.out.println("4. Add a book to  recommendation");
            System.out.println("5. Remove a book from recommendation");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1) {
                System.out.println("Current Recommendations: ");
                System.out.println(rec1);

            } else if (choice == 2) {
                // Clone the recommendation
                Recommendation clonedRec = rec1.clone();
                System.out.println("Cloned Recommendation: ");
                System.out.println(clonedRec);

            } else if (choice == 3) {
                // Modify the target audience
                System.out.print("Enter new target audience: ");
                String newAudience = scanner.nextLine();

                rec1.modifyTargetAudience(newAudience);
                System.out.println("Recommendation updated: ");
                System.out.println(rec1);


            } else if (choice == 4) {
                System.out.println("Add a book to the recommendation by title");
                System.out.print("Enter title: ");
                String title = scanner.nextLine();

                boolean found = false;
                for (Book book : books) {
                    if (book.getTitle().equals(title)) {
                        rec1.addBook(book);
                        System.out.println("Book added to the recommendation.");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Book with the given title not found.");
                }
            } else if (choice == 5) {
                System.out.println("Remove a book from the recommendation");
                System.out.print("Enter title: ");
                String title = scanner.nextLine();

                for (Book book : books) {
                    if (book.getTitle().equals(title)) {
                        rec1.removeBook(book);
                        System.out.println("Book removed from the recommendation: ");
                        break;
                    }
                }

            } else if (choice == 6) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
        scanner.close();
    }
}
