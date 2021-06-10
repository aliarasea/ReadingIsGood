package com.aliaras.readingisgood.service.book;

import com.aliaras.readingisgood.model.book.BookEntity;

public interface IBookService {
    BookEntity get(BookEntity bookEntity);

    BookEntity save(BookEntity bookEntity);

    boolean delete(BookEntity bookEntity);
}
