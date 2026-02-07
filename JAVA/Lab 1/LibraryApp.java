import java.util.*;

// 1. Create a class named Book
class Book {
    // 2. Data members with specified access modifiers
    private int bookId;             // private
    private StringBuffer title;     // private, type StringBuffer
    protected String author;        // protected
    public boolean isAvailable;     // public

    // 3. Member Functions

    // Constructor to initialize all data members
    public Book(int bookId, String title, String author, boolean isAvailable) {
        this.bookId = bookId;
        // Converting String to StringBuffer for the title
        this.title = new StringBuffer(title);
        this.author = author;
        this.isAvailable = isAvailable;
    }

    // Method to update the existing book title using StringBuffer
    public void updateTitle(String newTitle) {
        // Using replace() to overwrite the old title with the new one
        // This covers the requirement to use StringBuffer methods like replace()
        this.title.replace(0, this.title.length(), newTitle);
        System.out.println("Success: Title updated to '" + this.title + "'");
    }

    // Method to change the availability of the book
    public void changeAvailability(boolean status) {
        this.isAvailable = status;
        System.out.println("Success: Availability status updated.");
    }

    // Method to display book information in a readable format
    public void displayBookDetails() {
        System.out.println("\n=== Book Details ===");
        System.out.println("Book ID:      " + bookId);
        System.out.println("Title:        " + title);
        System.out.println("Author:       " + author);
        System.out.println("Available:    " + (isAvailable ? "Yes" : "No"));
        System.out.println("====================");
    }
    
    // Getter for title to use in demonstrations (optional helper)
    public StringBuffer getTitleBuffer() {
        return title;
    }
}

// 4. Create another class named LibraryApp containing the main() method
public class LibraryApp {

    public static void main(String[] args) {
        System.out.println("--- Library Management System Started ---\n");

        // 5. In the main() method:

        // a. Create at least one Book object
        Book myBook = new Book(101, "Java Programming", "James Gosling", true);
        
        // Display initial details
        myBook.displayBookDetails();

        // b. Update the book title
        // This implicitly demonstrates the use of StringBuffer.replace() inside the class
        System.out.println("Updating title...");
        myBook.updateTitle("Advanced Java Programming");

        // c. Change the availability status
        System.out.println("Changing availability...");
        myBook.changeAvailability(false);

        // d. Display the updated book details
        myBook.displayBookDetails();

        // ---------------------------------------------------------
        // EXTRA: Demonstration of Methods listed in Lab Images
        // ---------------------------------------------------------
        System.out.println("\n--- Demonstration of String & StringBuffer Methods ---");
        
        StringBuffer sb = new StringBuffer("Library");

        // 1. append()
        sb.append(" Books");
        System.out.println("append(): " + sb); // Output: Library Books

        // 2. insert()
        sb.insert(7, " Fine"); 
        System.out.println("insert(): " + sb); // Output: Library Fine Books

        // 3. delete()
        sb.delete(7, 12); 
        System.out.println("delete(): " + sb); // Output: Library Books

        // 4. capacity()
        System.out.println("capacity(): " + sb.capacity());

        // 5. setLength()
        sb.setLength(7);
        System.out.println("setLength(7): " + sb); // Output: Library

        // 6. charAt()
        System.out.println("charAt(0): " + sb.charAt(0)); // Output: L

        // 7. substring()
        System.out.println("substring(0, 3): " + sb.substring(0, 3)); // Output: Lib
        
        // String comparison methods (from the second image list)
        String s1 = "Hello";
        String s2 = " hello "; // has spaces and lowercase

        // trim()
        System.out.println("trim(): '" + s2.trim() + "'");
        
        // equals() (Case sensitive)
        System.out.println("equals(): " + s1.equals(s2.trim())); // false
        
        // equalsIgnoreCase (often used with equals)
        System.out.println("equalsIgnoreCase(): " + s1.equalsIgnoreCase(s2.trim())); // true
        
        // indexOf()
        System.out.println("indexOf('e') in s1: " + s1.indexOf('e')); // 1
    }
}