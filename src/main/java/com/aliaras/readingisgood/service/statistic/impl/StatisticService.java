package com.aliaras.readingisgood.service.statistic.impl;

import com.aliaras.readingisgood.model.statistic.StatisticEntity;
import com.aliaras.readingisgood.service.book.IBookService;
import com.aliaras.readingisgood.service.order.IOrderService;
import com.aliaras.readingisgood.service.statistic.IStatisticService;
import com.aliaras.readingisgood.service.statistic.util.StatisticUtil;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.Map;

@Service
public class StatisticService implements IStatisticService {

    private final IBookService iBookService;
    private final IOrderService iOrderService;
    private final StatisticUtil statisticUtil;

    public StatisticService(IBookService iBookService, IOrderService iOrderService, StatisticUtil statisticUtil) {
        this.iBookService = iBookService;
        this.iOrderService = iOrderService;
        this.statisticUtil = statisticUtil;
    }

    @Override
    public Map<Month, Integer> getTotalOrderCount() {
         //iOrderService.getAll().stream().collect(Collectors.groupingBy(OrderEntity::setCreatedAt)));
        return null;
    }

    @Override
    public Map<Month, Double> getTotalPurchaseOrderAmount() {
        //List<BookEntity> purchasedBooks = statisticUtil.getAllPurchasedBookList(iOrderService, iBookService);
        //purchasedBooks.stream().mapToDouble(BookEntity::getPrice).sum();
        return null;
    }

    @Override
    public Map<Month, Integer> getTotalPurchasedBookCount() {
        //List<BookEntity> purchasedBooks = statisticUtil.getAllPurchasedBookList(iOrderService, iBookService);
        return null;
    }

    public StatisticEntity getSupplyData() {
        StatisticEntity statisticEntity = new StatisticEntity();
        statisticEntity.setTotalOrderCount(getTotalOrderCount());
        statisticEntity.setTotalPurchasedOrderAmount(getTotalPurchaseOrderAmount());
        statisticEntity.setTotalPurchasedBookCount(getTotalPurchasedBookCount());
        return statisticEntity;
    }
}
