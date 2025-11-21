public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("A Study in Scarlet", "Arthur Conan Doyle", 10);
        Book book2 = new Book("The Adventures of Sherlock Holmes", "Arthur Conan Doyle");
        Book book3 = new Book();
        book2.price = 15;
        book3.title = "The Memoirs of Sherlock Holmes";
        book3.author = "Arthur Conan Doyle";
        book3.price = 20;

        System.out.println(book1.title);
        System.out.println(book1.author);
        System.out.println(book1.price);
        System.out.println(book2.title);
        System.out.println(book2.author);
        System.out.println(book2.price);
        System.out.println(book3.title);
        System.out.println(book3.author);
        System.out.println(book3.price);
    }
}