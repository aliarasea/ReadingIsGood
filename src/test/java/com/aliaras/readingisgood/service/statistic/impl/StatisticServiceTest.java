package com.aliaras.readingisgood.service.statistic.impl;

import com.aliaras.readingisgood.model.statistic.StatisticEntity;
import com.aliaras.readingisgood.service.book.IBookService;
import com.aliaras.readingisgood.service.order.IOrderService;
import com.aliaras.readingisgood.service.statistic.util.StatisticUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StatisticServiceTest {

    @Mock
    IBookService iBookService;

    @Mock
    IOrderService iOrderService;

    @Mock
    StatisticUtil statisticUtil;

    @InjectMocks
    StatisticService statisticService;

    @Test
    void getTotalOrderCount() {
        Assertions.assertNull(statisticService.getTotalOrderCount());
    }

    @Test
    void getTotalPurchaseOrderAmount() {
        Assertions.assertNull(statisticService.getTotalPurchaseOrderAmount());
    }

    @Test
    void getTotalPurchasedBookCount() {
        Assertions.assertNull(statisticService.getTotalPurchasedBookCount());
    }

    @Test
    void getSupplyData() {
        Assertions.assertSame(statisticService.getSupplyData().getClass(), StatisticEntity.class);
    }
}