package com.mycompany.book.api;

public class BookAPI {

    private final BookService service = new BookService();

    public String getStatus() {
        return "Book API Running";
    }

    public String previewBook(Book book) {

        service.validateBook(book);

        double finalPrice = service.applyDiscount(book);

        return service.generateBookLabel(book)
                + " | Final Price: "
                + finalPrice;
    }
}