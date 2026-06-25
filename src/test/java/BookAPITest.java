package com.mycompany.book.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookAPITest {

    private final BookAPI api = new BookAPI();

    @Test
    void getStatus_shouldReturnRunningMessage() {

        assertEquals("Book API Running",
                api.getStatus());
    }

    @Test
    void previewBook_noDiscount() {

        Book book = new Book(1, "Java", "Author", 100000);

        String result = api.previewBook(book);

        assertEquals(
                "Java - Author | Final Price: 100000.0",
                result);
    }

    @Test
    void previewBook_fivePercentDiscount() {

        Book book = new Book(1, "Java", "Author", 300000);

        String result = api.previewBook(book);

        assertEquals(
                "Java - Author | Final Price: 285000.0",
                result);
    }
    
    @Test
    void previewBook_fivePercentDiscountFailed() {

        Book book = new Book(1, "Java", "Author", 300000);

        String result = api.previewBook(book);

        assertEquals(
                "Java - Author | Final Price: 300000.0",
                result);
    }


    @Test
    void previewBook_tenPercentDiscount() {

        Book book = new Book(1, "Java", "Author", 600000);

        String result = api.previewBook(book);

        assertEquals(
                "Java - Author | Final Price: 540000.0",
                result);
    }

    @Test
    void previewBook_invalidBook() {

        Book book = new Book(0, "", "", 0);

        assertThrows(InvalidBookException.class,
                () -> api.previewBook(book));
    }
}