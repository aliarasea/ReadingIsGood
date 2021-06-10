package com.aliaras.readingisgood.restcontroller.order;

import com.aliaras.readingisgood.app.aspect.ReadingIsGoodLogger;
import com.aliaras.readingisgood.model.customer.CustomerEntity;
import com.aliaras.readingisgood.model.order.OrderEntity;
import com.aliaras.readingisgood.service.order.IOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderRestController {

    private final IOrderService iOrderService;

    public OrderRestController(IOrderService iOrderService) {
        this.iOrderService = iOrderService;
    }

    @ReadingIsGoodLogger
    @PostMapping("/getAll")
    public ResponseEntity<List<OrderEntity>> getAll(@RequestBody CustomerEntity customerEntity) {
        return new ResponseEntity<>(iOrderService.getAll(customerEntity), HttpStatus.OK);
    }

    @ReadingIsGoodLogger
    @PostMapping("/getAllById")
    public ResponseEntity<List<OrderEntity>> getAll(@RequestBody List<Long> orderIdList) {
        return new ResponseEntity<>(iOrderService.getAll(orderIdList), HttpStatus.OK);
    }

    @ReadingIsGoodLogger
    @PostMapping("/getAllByDate")
    public ResponseEntity<List<OrderEntity>> getAll(@RequestBody CustomerEntity customerEntity, @RequestBody Date startDate, @RequestBody Date endDate) {
        return new ResponseEntity<>(iOrderService.getAll(customerEntity, startDate, endDate), HttpStatus.OK);
    }

    @ReadingIsGoodLogger
    @PostMapping("/save")
    public ResponseEntity<OrderEntity> save(@RequestBody OrderEntity orderEntity) {
        return new ResponseEntity<>(iOrderService.save(orderEntity), HttpStatus.OK);
    }

    @ReadingIsGoodLogger
    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> delete(@RequestBody OrderEntity orderEntity) {
        return new ResponseEntity<>(iOrderService.delete(orderEntity), HttpStatus.OK);
    }
}
