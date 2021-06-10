package com.aliaras.readingisgood.service.order.impl;

import com.aliaras.readingisgood.data.access.order.impl.OrderDao;
import com.aliaras.readingisgood.model.customer.CustomerEntity;
import com.aliaras.readingisgood.model.order.OrderEntity;
import com.aliaras.readingisgood.service.order.IOrderService;
import com.aliaras.readingisgood.service.order.util.OrderUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.repository.cdi.Eager;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    OrderEntity orderEntity;

    @Mock
    CustomerEntity customerEntity;

    @Mock
    OrderDao orderDao;

    @Mock
    OrderUtil orderUtil;

    @InjectMocks
    OrderService orderService;

    @Mock
    IOrderService iOrderService = new OrderService(orderDao, orderUtil);

    @Test
    void save() {
        Assertions.assertDoesNotThrow(() -> orderService.save(orderEntity));
        Assertions.assertDoesNotThrow(() -> iOrderService.save(orderEntity));
    }


    @Test
    void delete() {
        Assertions.assertDoesNotThrow(() -> orderService.delete(orderEntity));
        Assertions.assertDoesNotThrow(() -> iOrderService.delete(orderEntity));
    }

    @Test
    void getAll() {
        Assertions.assertDoesNotThrow(() -> orderService.getAll(customerEntity));
        Assertions.assertDoesNotThrow(() -> iOrderService.getAll(customerEntity));
    }
}