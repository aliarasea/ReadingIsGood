package com.aliaras.readingisgood.service.book.impl;

import com.aliaras.readingisgood.data.access.book.impl.BookDao;
import com.aliaras.readingisgood.model.book.BookEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    BookDao bookDao;

    @Mock
    BookEntity bookEntity;

    @InjectMocks
    BookService bookService;

    @Test
    void add() {
        Assertions.assertDoesNotThrow(() -> bookService.save(bookEntity));
    }

    @Test
    void delete() {
        Assertions.assertDoesNotThrow(() -> bookService.delete(bookEntity));
    }
}