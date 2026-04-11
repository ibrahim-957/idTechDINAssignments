package com.ibrahim.spring.lesson02.task03_rest_resource_design;

import java.util.List;

public class LibraryController {
    private final BookRepository   bookRepo   = new BookRepository();
    private final AuthorRepository authorRepo = new AuthorRepository();
    private final BorrowRepository borrowRepo = new BorrowRepository();

    // ── GET /books?page=0&size=5 ──────────────────────────────────────────
    public PagedResponse<Book> getAllBooks(int page, int size) {
        return PagedResponse.of(bookRepo.findAll(), page, size);
    }

    // ── GET /books/{id} ───────────────────────────────────────────────────
    public ApiResponse<Book> getBook(int id) {
        return bookRepo.findById(id)
                .<ApiResponse<Book>>map(ApiResponse::ok)
                .orElse(ApiResponse.notFound("Book not found: id=" + id));
    }

    // ── POST /books ───────────────────────────────────────────────────────
    public ApiResponse<Book> createBook(String title, int authorId, String isbn, int year) {
        if (bookRepo.existsByIsbn(isbn)) {
            return ApiResponse.conflict("A book with ISBN " + isbn + " already exists");
        }
        return ApiResponse.created(bookRepo.create(title, authorId, isbn, year));
    }

    // ── PUT /books/{id} ───────────────────────────────────────────────────
    public ApiResponse<Book> updateBook(int id, String title, int authorId, String isbn, int year) {
        if (bookRepo.findById(id).isEmpty()) {
            return ApiResponse.notFound("Book not found: id=" + id);
        }
        Book updated = bookRepo.save(new Book(id, title, authorId, isbn, year));
        return ApiResponse.ok(updated);
    }

    // ── DELETE /books/{id} ────────────────────────────────────────────────
    public ApiResponse<Void> deleteBook(int id) {
        if (!bookRepo.delete(id)) {
            return ApiResponse.notFound("Book not found: id=" + id);
        }
        return ApiResponse.noContent();
    }

    // ── GET /authors/{id}/books ───────────────────────────────────────────
    public ApiResponse<List<Book>> getBooksByAuthor(int authorId) {
        if (authorRepo.findById(authorId).isEmpty()) {
            return ApiResponse.notFound("Author not found: id=" + authorId);
        }
        List<Book> books = bookRepo.findByAuthorId(authorId);
        return ApiResponse.ok(books);
    }

    // ── POST /books/{id}/borrow ───────────────────────────────────────────
    public ApiResponse<BorrowedBook> borrowBook(int bookId, String borrower) {
        if (bookRepo.findById(bookId).isEmpty()) {
            return ApiResponse.notFound("Book not found: id=" + bookId);
        }
        if (borrowRepo.findByBookId(bookId).isPresent()) {
            return ApiResponse.conflict("Book id=" + bookId + " is already borrowed");
        }
        return ApiResponse.created(borrowRepo.borrow(bookId, borrower));
    }
}

