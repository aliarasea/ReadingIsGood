package com.aliaras.readingisgood.data.repo.book;

import com.aliaras.readingisgood.model.book.BookEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IBookRepository extends MongoRepository<BookEntity, Long> {
}
