package week.four.nine;

import java.util.Objects;

public class LibraryBook {
    private String isbn;
    private String title;
    private String author;
    private int year;
    private boolean isAvailable;
    static int countOfBooksCreated = 0;

    public LibraryBook(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        if (year>1450){
            this.year = year;
        } else {
            System.out.println("release year at least 1450");
            this.year = 1450;
        }
        isAvailable = true;
        countOfBooksCreated++;
    }

    public void checkOut() {
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }

    public void setYear(int year) {
        if (year > 1450){
            this.year = year;
        }
        else{
            System.out.println("Year out of range");
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public static int getCountOfBooksCreated() {
        return countOfBooksCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LibraryBook that = (LibraryBook) o;
        return Objects.equals(isbn, that.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return "LibraryBook{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", isAvailable=" + isAvailable +
                '}';
    }

    public static void main(String[] args) {
        LibraryBook libraryBook = new LibraryBook("1","1","1",1541);
        LibraryBook libraryBook2 = new LibraryBook("2","2","2",1542);
        LibraryBook libraryBook3 = new LibraryBook("3","3","3",1543);
        libraryBook.checkOut();
        libraryBook2.checkOut();
        libraryBook3.checkOut();
        libraryBook.returnBook();

        System.out.println(libraryBook);
        System.out.println(libraryBook2);
        System.out.println(libraryBook3);
    }
}
