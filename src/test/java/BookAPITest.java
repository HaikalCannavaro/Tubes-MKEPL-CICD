package com.mycompany.book.api;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookAPITest {

    @Test
    void testGetBookReturnsCorrectMessage() {
        assertEquals(
                "Book API Running",
                BookAPI.getBook()
        );
    }

    @Test
    void testGetBookNotNull() {
        assertNotNull(BookAPI.getBook());
    }

    @Test
    void testGetBookNotEmpty() {
        assertFalse(BookAPI.getBook().isEmpty());
    }
}