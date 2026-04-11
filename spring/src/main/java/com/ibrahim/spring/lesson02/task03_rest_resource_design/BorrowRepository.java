package com.ibrahim.spring.lesson02.task03_rest_resource_design;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class BorrowRepository {
    private final Map<Integer, BorrowedBook> store = new LinkedHashMap<>();
    private int seq = 1;

    Optional<BorrowedBook> findByBookId(int bookId){
        return store.values().stream()
                .filter(b -> b.bookId() == bookId)
                .findFirst();
    }

    BorrowedBook borrow(int bookId, String borrower){
        BorrowedBook bb = new BorrowedBook(
                seq++, bookId, borrower,
                LocalDateTime.now(),
                LocalDateTime.now().plusDays(14));
        store.put(bb.id(), bb);
        return bb;
    }
}
