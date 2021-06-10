package com.aliaras.readingisgood.service.statistic;

import com.aliaras.readingisgood.model.statistic.StatisticEntity;

import java.time.Month;
import java.util.Map;

public interface IStatisticService {

    Map<Month, Integer> getTotalOrderCount();

    Map<Month, Double> getTotalPurchaseOrderAmount();

    Map<Month, Integer> getTotalPurchasedBookCount();

    StatisticEntity getSupplyData();
}
