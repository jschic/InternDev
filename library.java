import java.util.ArrayList;
import java.util.Scanner;
class Book {
    String title;
    String author;
    String publicationDate;
    boolean available;
    public Book(String title, String author, String publicationDate) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.available = true;
    }
}
class Library {
    ArrayList<Book> books = new ArrayList<>();
    public void addBook(String title, String author, String publicationDate) {
        Book book = new Book(title, author, publicationDate);
        books.add(book);
    }
    public void displayBooks() {
        System.out.println("Library Collection:");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            String availability = book.available ? "Available" : "Not Available";
            System.out.println((i + 1) + ". Title: " + book.title + ", Author: " + book.author
                    + ", Publication Date: " + book.publicationDate + ", Status: " + availability);
        }
    }
    public void checkoutBook(int index) {
        if (index >= 0 && index < books.size()) {
            Book book = books.get(index);
            if (book.available) {
                book.available = false;
                System.out.println("Book \"" + book.title + "\" has been checked out.");
            } else {
                System.out.println("Book \"" + book.title + "\" is not available for checkout.");
            }
        } else {
            System.out.println("Invalid book index.");
        }
    }
    public void returnBook(int index) {
        if (index >= 0 && index < books.size()) {
            Book book = books.get(index);
            if (!book.available) {
                book.available = true;
                System.out.println("Book \"" + book.title + "\" has been returned.");
            } else {
                System.out.println("This book is already available in the library.");
            }
        } else {
            System.out.println("Invalid book index.");
        }
    }
}
public class library {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        while (true) {
            System.out.println("1. Add Book\n2. Display Books\n3. Checkout Book\n4. Return Book\n5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter publication date: ");
                    String publicationDate = scanner.nextLine();
                    library.addBook(title, author, publicationDate);
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    System.out.print("Enter the index of the book to checkout: ");
                    int checkoutIndex = scanner.nextInt();
                    library.checkoutBook(checkoutIndex - 1);
                    break;
                case 4:
                    System.out.print("Enter the index of the book to return: ");
                    int returnIndex = scanner.nextInt();
                    library.returnBook(returnIndex - 1);
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
