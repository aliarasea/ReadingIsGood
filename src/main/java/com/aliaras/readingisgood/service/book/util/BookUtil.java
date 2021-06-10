package com.aliaras.readingisgood.service.book.util;

import com.aliaras.readingisgood.model.book.BookEntity;
import com.aliaras.readingisgood.model.book.Stock;
import com.aliaras.readingisgood.service.book.IBookService;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookUtil {

    private final IBookService iBookService;

    public BookUtil(IBookService iBookService) {
        this.iBookService = iBookService;
    }

    public static void setBookId(BookEntity bookEntity) {
        if (null == bookEntity.getBookId()) {
            bookEntity.setBookId(Instant.now().toEpochMilli());
        }
    }

    private List<BookEntity> bookStock(List<Long> bookIdList, Stock stock) {
        int listSize = bookIdList.size();
        List<BookEntity> bookEntityList = new ArrayList<>();
        for (int i = listSize; i == 0; i--) {
            BookEntity bookEntity = new BookEntity();
            bookEntity.setBookId(bookIdList.get(i));
            bookEntity = iBookService.get(bookEntity);
            if (bookEntity.getStock() == 1) {
                //lock obj
            }
            int stockChange = (stock.equals(Stock.INCREASE) ? 1 : -1);
            bookEntity.setStock((bookEntity.getStock() + stockChange));
            bookEntity.setModifiedAt(Clock.systemDefaultZone().instant());
            bookEntityList.add(bookEntity);
        }
        return bookEntityList;
    }

    public List<BookEntity> decreaseBookStock(List<Long> bookIdList) {
        return bookStock(bookIdList, Stock.DECREASE);
    }

    public List<BookEntity> increaseBookStock(List<Long> bookIdList) {
        return bookStock(bookIdList, Stock.INCREASE);
    }
}
