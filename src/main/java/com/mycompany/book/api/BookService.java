package com.mycompany.book.api;

public class BookService {

    public void validateBook(Book book) {

        if (book == null) {
            throw new InvalidBookException("Book cannot be null");
        }

        if (book.getId() <= 0) {
            throw new InvalidBookException("Book ID must be greater than 0");
        }

        if (book.getTitle() == null || book.getTitle().isBlank()) {
            throw new InvalidBookException("Title cannot be empty");
        }

        if (book.getAuthor() == null || book.getAuthor().isBlank()) {
            throw new InvalidBookException("Author cannot be empty");
        }

        if (book.getPrice() <= 0) {
            throw new InvalidBookException("Price must be greater than 0");
        }
    }

    public double applyDiscount(Book book) {

        validateBook(book);

        double price = book.getPrice();

        if (price >= 500000) {
            return price * 0.90;
        }

        if (price >= 250000) {
            return price * 0.95;
        }

        return price;
    }

    public boolean isExpensive(Book book) {

        validateBook(book);

        return book.getPrice() >= 300000;
    }

    public String generateBookLabel(Book book) {

        validateBook(book);

        return book.getTitle() + " - " + book.getAuthor();
    }
}