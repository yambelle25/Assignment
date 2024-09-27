public class Main {
    public static void main(String[] args) {
        Library library = new Library();
       
       
        library.addBook(new Book("Harry Potter", "J.K. Rowling", "12345"));
        library.addBook(new Book("Lord of the Rings", "J.R.R. Tolkien", "67890"));

        User alice = new User("Alice", 30);
        User bob = new User("Bob", 20);
       
       
        library.addUser(alice);
        library.addUser(bob);

        System.out.println("--- Available Books ---");
       
        library.listAvailableBooks();

        System.out.println("\n--- Borrowing a Book ---");
       
        library.borrowBook(alice, "Harry Potter");
        library.borrowBook(bob, "Lord of the Rings");

        System.out.println("\n--- Overdue Books ---");

        alice.checkDueDates();
        bob.checkDueDates();

    }
}