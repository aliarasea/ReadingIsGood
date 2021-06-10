package com.aliaras.readingisgood.data.access.book;

import com.aliaras.readingisgood.model.book.BookEntity;

public interface IBookDao {
    BookEntity get(BookEntity bookEntity);

    BookEntity save(BookEntity bookEntity);

    boolean delete(BookEntity bookEntity);
}
