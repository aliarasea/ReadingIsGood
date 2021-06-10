package com.aliaras.readingisgood.service.order.util;

import com.aliaras.readingisgood.model.order.OrderEntity;
import com.aliaras.readingisgood.service.book.util.BookUtil;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class OrderUtil {

    private final BookUtil bookUtil;

    public OrderUtil(BookUtil bookUtil) {
        this.bookUtil = bookUtil;
    }

    public void setOrderId(OrderEntity orderEntity) {
        if (null == orderEntity.getOrderId()) {
            orderEntity.setOrderId(Instant.now().toEpochMilli());
        }
    }

    public void decreaseBookStock(List<Long> bookIdList) {
        bookUtil.decreaseBookStock(bookIdList);
    }

    public void increaseBookStock(List<Long> bookIdList) {
        bookUtil.increaseBookStock(bookIdList);
    }
}
