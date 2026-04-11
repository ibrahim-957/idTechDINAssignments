package com.ibrahim.spring.lesson02.task03_rest_resource_design;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class BookRepository {
    private final Map<Integer, Book> store = new LinkedHashMap<>();
    private int seq = 1;

    BookRepository() {
        save(new Book(seq++, "Clean Code",              1, "978-0132350884", 2008));
        save(new Book(seq++, "The Pragmatic Programmer", 1, "978-0135957059", 1999));
        save(new Book(seq++, "Design Patterns",          2, "978-0201633610", 1994));
    }

    List<Book> findAll(){
        return new ArrayList<>(store.values());
    }

    Optional<Book> findById(int id){
        return Optional.ofNullable(store.get(id));
    }

    List<Book> findByAuthorId(int id){
        return store.values().stream()
                .filter(b -> b.authorId() == id)
                .toList();
    }

    boolean existsByIsbn(String isbn){
        return store.values().stream()
                .anyMatch(b -> b.isbn().equals(isbn));
    }

    Book save(Book book){
        store.put(book.id(), book);
        return book;
    }

    Book create(String title, int authorId, String isbn, int year){
        Book b = new Book(seq++, title, authorId, isbn, year);
        return save(b);
    }

    boolean delete(int id){
        return store.remove(id) != null;
    }
}
