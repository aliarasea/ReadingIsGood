package com.aliaras.readingisgood.service.book.impl;

import com.aliaras.readingisgood.app.aspect.ReadingIsGoodLogger;
import com.aliaras.readingisgood.data.access.book.IBookDao;
import com.aliaras.readingisgood.model.book.BookEntity;
import com.aliaras.readingisgood.service.book.IBookService;
import com.aliaras.readingisgood.service.book.util.BookUtil;
import lombok.Synchronized;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Transactional
@Service
public class BookService implements IBookService {

    private final IBookDao iBookDao;

    public BookService(IBookDao iBookDao) {
        this.iBookDao = iBookDao;
    }

    @ReadingIsGoodLogger
    @Synchronized
    @Override
    public BookEntity get(BookEntity bookEntity) {
        return iBookDao.get(bookEntity);
    }


    @ReadingIsGoodLogger
    @Synchronized
    @Override
    public BookEntity save(BookEntity bookEntity) {
        BookUtil.setBookId(bookEntity);
        return iBookDao.save(bookEntity);
    }

    @ReadingIsGoodLogger
    @Synchronized
    @Override
    public boolean delete(BookEntity bookEntity) {
        return iBookDao.delete(bookEntity);
    }
}
