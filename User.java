import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class User {
    private String name;
    private int age;
    private ArrayList<String> borrowedBooks;
    private Map<String, LocalDate> borrowedBooksDueDates;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.borrowedBooks = new ArrayList<>();
        this.borrowedBooksDueDates = new HashMap<>();
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public void borrowBook(String bookTitle) {
        borrowedBooks.add(bookTitle);
        // Setting the due date to 14 days from now
        borrowedBooksDueDates.put(bookTitle, LocalDate.now().plusDays(14));
    }

    public void returnBook(String bookTitle) {
        if (borrowedBooks.remove(bookTitle)) {
            borrowedBooksDueDates.remove(bookTitle);
            System.out.println("Successfully returned " + bookTitle);
        } else {
            System.out.println("Failed to return " + bookTitle);
        }
    }

    public void printBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books borrowed.");
        } else {
            for (String book : borrowedBooks) {
                System.out.println(book);
            }
        }
    }

    public void checkDueDates() {
        Set<Map.Entry<String, LocalDate>> entries = borrowedBooksDueDates.entrySet();
        for (Map.Entry<String, LocalDate> entry : entries) {
            System.out.println(name + ", Due Date: " + entry.getValue());
        }
    }

    public void checkOverdueBooks() {
        LocalDate today = LocalDate.now();
        for (Map.Entry<String, LocalDate> entry : borrowedBooksDueDates.entrySet()) {
            long daysOverdue = today.until(entry.getValue()).getDays();
            if (daysOverdue < 0) {
                System.out.println("Book: " + entry.getKey() + ", Overdue by " + Math.abs(daysOverdue) + " days");
            }
        }
    }
}