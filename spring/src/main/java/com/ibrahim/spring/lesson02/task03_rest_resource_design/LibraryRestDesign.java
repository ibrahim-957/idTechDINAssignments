package com.ibrahim.spring.lesson02.task03_rest_resource_design;

public class LibraryRestDesign {
    static final LibraryController ctrl = new LibraryController();

    static void banner(String title) {
        System.out.println("\n╔══ " + title);
    }

    public static void main(String[] args) {

        // ── 1. GET /books?page=0&size=2 ───────────────────────────────────
        banner("GET /books?page=0&size=2");
        System.out.println(ctrl.getAllBooks(0, 2));

        // ── 2. GET /books/{id} — found ────────────────────────────────────
        banner("GET /books/1");
        System.out.println(ctrl.getBook(1));

        // ── 3. GET /books/{id} — not found ───────────────────────────────
        banner("GET /books/999");
        System.out.println(ctrl.getBook(999));

        // ── 4. POST /books — success ──────────────────────────────────────
        banner("POST /books  { title: 'Refactoring', authorId: 1, isbn: '978-0134757599', year: 2018 }");
        System.out.println(ctrl.createBook("Refactoring", 1, "978-0134757599", 2018));

        // ── 5. POST /books — duplicate ISBN ──────────────────────────────
        banner("POST /books  { isbn: '978-0132350884' }  ← duplicate");
        System.out.println(ctrl.createBook("Duplicate", 1, "978-0132350884", 2020));

        // ── 6. PUT /books/{id} ────────────────────────────────────────────
        banner("PUT /books/1  { title: 'Clean Code (2nd Ed)' }");
        System.out.println(ctrl.updateBook(1, "Clean Code (2nd Ed)", 1, "978-0132350884", 2024));

        // ── 7. DELETE /books/{id} — success ──────────────────────────────
        banner("DELETE /books/2");
        System.out.println(ctrl.deleteBook(2));

        // ── 8. DELETE /books/{id} — already gone ─────────────────────────
        banner("DELETE /books/2  ← already deleted");
        System.out.println(ctrl.deleteBook(2));

        // ── 9. GET /authors/{id}/books ────────────────────────────────────
        banner("GET /authors/1/books");
        System.out.println(ctrl.getBooksByAuthor(1));

        // ── 10. GET /authors/{id}/books — author not found ────────────────
        banner("GET /authors/999/books");
        System.out.println(ctrl.getBooksByAuthor(999));

        // ── 11. POST /books/{id}/borrow — success ─────────────────────────
        banner("POST /books/1/borrow  { borrower: 'Charlie' }");
        System.out.println(ctrl.borrowBook(1, "Charlie"));

        // ── 12. POST /books/{id}/borrow — already borrowed ────────────────
        banner("POST /books/1/borrow  ← already borrowed");
        System.out.println(ctrl.borrowBook(1, "Dana"));
    }
}


/*
 * ╔══════════════════════════════════════════════════════════════════════════╗
 * ║  WHAT IS HATEOAS AND HOW WOULD YOU ADD LINKS?                           ║
 * ╠══════════════════════════════════════════════════════════════════════════╣
 * ║                                                                          ║
 * ║  HATEOAS = Hypermedia As The Engine Of Application State.               ║
 * ║  It is Level 3 of the Richardson Maturity Model — true REST.            ║
 * ║                                                                          ║
 * ║  The idea: every response includes _links that tell the client what      ║
 * ║  actions are available NEXT, so the client never hard-codes URLs.        ║
 * ║                                                                          ║
 * ║  Example — GET /books/1 response WITH HATEOAS:                          ║
 * ║  {                                                                        ║
 * ║    "data": { "id": 1, "title": "Clean Code" },                          ║
 * ║    "_links": {                                                            ║
 * ║      "self":      { "href": "/books/1",         "method": "GET"    },   ║
 * ║      "update":    { "href": "/books/1",         "method": "PUT"    },   ║
 * ║      "delete":    { "href": "/books/1",         "method": "DELETE" },   ║
 * ║      "borrow":    { "href": "/books/1/borrow",  "method": "POST"   },   ║
 * ║      "author":    { "href": "/authors/1/books", "method": "GET"    },   ║
 * ║      "collection":{ "href": "/books",           "method": "GET"    }    ║
 * ║    }                                                                      ║
 * ║  }                                                                        ║
 * ║                                                                          ║
 * ║  HOW TO ADD IN SPRING BOOT:                                              ║
 * ║    1. Add dependency: spring-boot-starter-hateoas                        ║
 * ║    2. Extend EntityModel<Book> instead of returning raw Book             ║
 * ║    3. Use WebMvcLinkBuilder:                                             ║
 * ║                                                                          ║
 * ║       EntityModel<Book> model = EntityModel.of(book);                    ║
 * ║       model.add(linkTo(methodOn(BookController.class)                    ║
 * ║                   .getBook(book.getId())).withSelfRel());                ║
 * ║       model.add(linkTo(methodOn(BookController.class)                    ║
 * ║                   .borrowBook(book.getId(), null)).withRel("borrow"));   ║
 * ║                                                                          ║
 * ║  WHY IT MATTERS:                                                         ║
 * ║    • Client code never hard-codes URLs — API can evolve URLs freely      ║
 * ║    • Response is self-documenting (links show what you can do next)      ║
 * ║    • Conditional links: "borrow" link absent if book is already borrowed ║
 * ║                                                                          ║
 * ║  WHY MOST APIs SKIP IT:                                                  ║
 * ║    • Significant implementation effort                                   ║
 * ║    • Clients (SPAs, mobile) rarely follow links dynamically              ║
 * ║    • OpenAPI/Swagger already documents available actions                 ║
 * ╚══════════════════════════════════════════════════════════════════════════╝
 */
