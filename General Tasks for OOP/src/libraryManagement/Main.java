package libraryManagement;

public class Main {
    public static void main(String[] args) {
        Library library = new Library(5);

        Book book1 = new Book("LOTM", "Cuttlefish", 2018);
        Book book2 = new Book("SS", "Guiltythree", 2022);

        library.addBook(book1);
        library.addBook(book2);

        library.showAvailableBooks();
    }
}
