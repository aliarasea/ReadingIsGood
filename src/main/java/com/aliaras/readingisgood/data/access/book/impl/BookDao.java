package com.aliaras.readingisgood.data.access.book.impl;

import com.aliaras.readingisgood.data.access.book.IBookDao;
import com.aliaras.readingisgood.data.repo.book.IBookRepository;
import com.aliaras.readingisgood.model.book.BookEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.time.Clock;
import java.time.Instant;

@Log4j2
@Repository
public class BookDao implements IBookDao {

    private final IBookRepository iBookRepository;

    public BookDao(IBookRepository iBookRepository) {
        this.iBookRepository = iBookRepository;
    }

    @Override
    public BookEntity get(BookEntity bookEntity) {
        return iBookRepository.findById(bookEntity.getBookId()).orElse(null);
    }

    @Override
    public BookEntity save(BookEntity bookEntity) {
        boolean exist = iBookRepository.findById(bookEntity.getBookId()).isPresent();
        if (!exist) {
            bookEntity.setBookId(Instant.now().toEpochMilli());
            bookEntity.setCreatedAt(Clock.systemDefaultZone().instant());
        } else {
            bookEntity.setModifiedAt(Clock.systemDefaultZone().instant());
        }
        return iBookRepository.save(bookEntity);
    }

    @Override
    public boolean delete(BookEntity bookEntity) {
        boolean exist = iBookRepository.findById(bookEntity.getBookId()).isPresent();
        if (exist) {
            iBookRepository.delete(bookEntity);
            return true;
        }
        return false;
    }
}
