package com.aliaras.readingisgood.data.access.book.impl;

import com.aliaras.readingisgood.data.access.book.IBookDao;
import com.aliaras.readingisgood.data.repo.book.IBookRepository;
import com.aliaras.readingisgood.model.book.BookEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookDaoTest {

    @Mock
    IBookRepository iBookRepository;

    @Mock
    BookEntity bookEntity;

    @InjectMocks
    BookDao bookDao;

    @Mock
    IBookDao iBookDao = new BookDao(iBookRepository);

    @Test
    void add() {
        Assertions.assertDoesNotThrow(() -> bookDao.save(bookEntity));
        Assertions.assertDoesNotThrow(() -> iBookDao.save(bookEntity));
    }

    @Test
    void delete() {
        Mockito.when(bookEntity.getBookId()).thenReturn(Long.MAX_VALUE);
        Mockito.when(iBookRepository.findById(bookEntity.getBookId())).thenReturn(Optional.of(bookEntity));
        Assertions.assertDoesNotThrow(() -> bookDao.delete(bookEntity));

        Assertions.assertDoesNotThrow(() -> iBookDao.delete(bookEntity));
    }

    @Test
    void get() {
        Assertions.assertDoesNotThrow(() -> iBookDao.get(bookEntity));
    }
}