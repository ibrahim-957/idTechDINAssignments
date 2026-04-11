package com.ibrahim.spring.lesson02.task03_rest_resource_design;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class AuthorRepository {
    private final Map<Integer, Author> store = new LinkedHashMap<>();

    AuthorRepository() {
        store.put(1, new Author(1, "Robert C. Martin", "American"));
        store.put(2, new Author(2, "Gang of Four",     "Mixed"));
    }

    Optional<Author> findById(int id) {
        return Optional.ofNullable(store.get(id));
    }
}
