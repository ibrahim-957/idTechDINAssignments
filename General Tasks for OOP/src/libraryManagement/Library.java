package libraryManagement;

public class Library {
    private Book[] books;
    private int count;

    public Library(int capacity){
        books = new Book[capacity];
        count = 0;
    }

    public void addBook(Book book){
        if(count < books.length){
            books[count] = book;
            count++;
        }
        else{
            System.out.println("Library is full");
        }
    }
    public void showAvailableBooks(){
        System.out.println("Available Books: ");
        for(int i = 0; i < count; i++){
            if (books[i].isAvailable()){
                System.out.println(books[i].getTitle());
            }
        }
    }
}
