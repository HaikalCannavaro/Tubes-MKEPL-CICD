package com.mycompany.book.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    private final BookService service = new BookService();

    @Test
    void validateBook_validBook() {

        Book book = new Book(1, "Clean Code", "Robert Martin", 200000);

        assertDoesNotThrow(() -> service.validateBook(book));
    }

    @Test
    void validateBook_nullBook() {
        assertThrows(InvalidBookException.class,
                () -> service.validateBook(null));
    }

    @Test
    void validateBook_invalidId() {

        Book book = new Book(0, "Java", "Author", 100000);

        assertThrows(InvalidBookException.class,
                () -> service.validateBook(book));
    }

    @Test
    void validateBook_emptyTitle() {

        Book book = new Book(1, "", "Author", 100000);

        assertThrows(InvalidBookException.class,
                () -> service.validateBook(book));
    }

    @Test
    void validateBook_emptyAuthor() {

        Book book = new Book(1, "Java", "", 100000);

        assertThrows(InvalidBookException.class,
                () -> service.validateBook(book));
    }

    @Test
    void validateBook_invalidPrice() {

        Book book = new Book(1, "Java", "Author", 0);

        assertThrows(InvalidBookException.class,
                () -> service.validateBook(book));
    }

    @Test
    void applyDiscount_tenPercent() {

        Book book = new Book(1, "Java", "Author", 600000);

        assertEquals(540000,
                service.applyDiscount(book));
    }

    @Test
    void applyDiscount_fivePercent() {

        Book book = new Book(1, "Java", "Author", 300000);

        assertEquals(285000,
                service.applyDiscount(book));
    }

    @Test
    void applyDiscount_noDiscount() {

        Book book = new Book(1, "Java", "Author", 100000);

        assertEquals(100000,
                service.applyDiscount(book));
    }

    @Test
    void isExpensive_true() {

        Book book = new Book(1, "Java", "Author", 350000);

        assertTrue(service.isExpensive(book));
    }

    @Test
    void isExpensive_false() {

        Book book = new Book(1, "Java", "Author", 150000);

        assertFalse(service.isExpensive(book));
    }

    @Test
    void generateBookLabel_success() {

        Book book = new Book(1, "Java", "Author", 100000);

        assertEquals("Java - Author",
                service.generateBookLabel(book));
    }
}