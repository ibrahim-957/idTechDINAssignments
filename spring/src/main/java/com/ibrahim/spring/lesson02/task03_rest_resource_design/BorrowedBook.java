package com.ibrahim.spring.lesson02.task03_rest_resource_design;

import java.time.LocalDateTime;

public record BorrowedBook(
        int id, int bookId, String borrowerName,
        LocalDateTime borrowedAt, LocalDateTime dueDate) {
}
