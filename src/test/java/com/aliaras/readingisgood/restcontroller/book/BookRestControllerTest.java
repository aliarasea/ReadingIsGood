package com.aliaras.readingisgood.restcontroller.book;

import com.aliaras.readingisgood.model.book.BookEntity;
import com.aliaras.readingisgood.service.book.IBookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.spy;

@ExtendWith(MockitoExtension.class)
class BookRestControllerTest {

    @Mock
    IBookService iBookService;

    @Mock
    BookEntity bookEntity;

    @InjectMocks
    BookRestController bookRestController;

    @Test
    void save() {
        Assertions.assertNotNull(bookEntity.getBookId());
        Assertions.assertDoesNotThrow(()->{bookRestController.save(bookEntity);});
    }

    @Test
    void update() {
        bookEntity = spy(BookEntity.class);
        bookEntity.setBookId(Long.MAX_VALUE);
        Assertions.assertNotNull(bookEntity.getBookId());
        Assertions.assertDoesNotThrow(()->{bookRestController.update(bookEntity);});
    }
}