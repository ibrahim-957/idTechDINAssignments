package libraryManagement;

public class Book {
    private String title;
    private String author;
    private Integer year;
    private Boolean isAvailable;

    public Book(String title, String author, Integer year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable = true;
    }

    public Boolean isAvailable() {
        return isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public void borrowBook(){
        if(isAvailable){
            isAvailable = false;
            System.out.println(title + " borrowed");
        }
        else{
            System.out.println(title + " not available");
        }
    }
    public void returnBook(){
        isAvailable = true;
        System.out.println(title + " returned");
    }
}
