package com.aliaras.readingisgood.service.statistic.util;

import com.aliaras.readingisgood.service.book.IBookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class StatisticUtilTest {

    @Spy
    List<List<Long>> orderedBookIdList = new ArrayList<>();

    @Mock
    IBookService iBookService;

    @InjectMocks
    StatisticUtil statisticUtil;

    @Test
    void getAllPurchasedBookList() {
        Assertions.assertDoesNotThrow(() -> statisticUtil.getAllPurchasedBookList(orderedBookIdList, iBookService));
    }
}