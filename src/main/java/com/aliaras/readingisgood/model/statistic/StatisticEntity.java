package com.aliaras.readingisgood.model.statistic;

import lombok.Getter;
import lombok.Setter;

import java.time.Month;
import java.util.Map;

@Getter
@Setter
public class StatisticEntity {
    private Map<Month, Integer> totalOrderCount;
    private Map<Month, Double> totalPurchasedOrderAmount;
    private Map<Month, Integer> totalPurchasedBookCount;
}
