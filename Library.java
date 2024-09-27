import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void borrowBook(User user, String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && book.isAvailable()) {
                book.setAvailable(false);
                user.borrowBook(title);
                System.out.println("User: " + user.getName() + ", Borrowed: " + title);
                return;
            }
        }
        System.out.println("Book not available or not found.");
    }

    public void listAvailableBooks() {
        for (Book book : books) {
            if (book.isAvailable()) {

                book.printBookInfo();
        }
    }
}

public void getBorrowedBooksForAllUsers() {
    for (User user : users) {
        System.out.println("User: " + user.getName() + "'s borrowed books:");
        user.printBorrowedBooks();
    }
}
}