package com.aliaras.readingisgood.service.statistic.util;

import com.aliaras.readingisgood.model.book.BookEntity;
import com.aliaras.readingisgood.model.order.OrderEntity;
import com.aliaras.readingisgood.model.order.Status;
import com.aliaras.readingisgood.service.book.IBookService;
import com.aliaras.readingisgood.service.order.IOrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatisticUtil {

    public List<List<Long>> getOrderedBookIdList(IOrderService iOrderService) {
        return iOrderService.getAll()
                .stream()
                .filter(f -> f.getStatus().equals(Status.PURCHASED))
                .map(OrderEntity::getBookIdList)
                .collect(Collectors.toList());
    }

    public List<BookEntity> getAllPurchasedBookList(List<List<Long>> orderedBookIdList, IBookService iBookService) {
        List<BookEntity> allPurchasedBookList = new ArrayList<>();

        for (List<Long> lst : orderedBookIdList) {
            for (Long bookId : lst) {
                BookEntity bookEntity = new BookEntity();
                bookEntity.setBookId(bookId);
                bookEntity = iBookService.get(bookEntity);
                allPurchasedBookList.add(bookEntity);
            }
        }
        return allPurchasedBookList;
    }

    public List<BookEntity> getAllPurchasedBookList(IOrderService iOrderService, IBookService iBookService) {
        List<List<Long>> orderedBookIdList = getOrderedBookIdList(iOrderService);
        return getAllPurchasedBookList(orderedBookIdList, iBookService);
    }

}
