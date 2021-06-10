package com.aliaras.readingisgood.restcontroller.statistic;

import com.aliaras.readingisgood.model.statistic.StatisticEntity;
import com.aliaras.readingisgood.service.statistic.IStatisticService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.Month;
import java.util.Map;

@RequestMapping(value = "/statistic")
@RestController
public class StatisticRestController {

    private final IStatisticService iStatisticService;

    public StatisticRestController(IStatisticService iStatisticService) {
        this.iStatisticService = iStatisticService;
    }

    @GetMapping(value = "/order/count")
    public ResponseEntity<Map<Month, Integer>> getTotalOrderCount() {
        return new ResponseEntity<>(iStatisticService.getTotalOrderCount(), HttpStatus.OK);
    }

    @GetMapping(value = "/order/amount")
    public ResponseEntity<Map<Month, Double>> getTotalPurchaseOrderAmount() {
        return new ResponseEntity<>(iStatisticService.getTotalPurchaseOrderAmount(), HttpStatus.OK);
    }

    @GetMapping(value = "/book/count")
    public ResponseEntity<Map<Month, Integer>> getTotalPurchasedBookCount() {
        return new ResponseEntity<>(iStatisticService.getTotalPurchasedBookCount(), HttpStatus.OK);
    }


    @GetMapping(value = "/supply")
    public ResponseEntity<StatisticEntity> getSupplyData() {
        return new ResponseEntity<>(iStatisticService.getSupplyData(), HttpStatus.OK);
    }

}
