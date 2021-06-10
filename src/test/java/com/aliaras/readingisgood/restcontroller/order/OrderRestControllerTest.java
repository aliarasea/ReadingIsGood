package com.aliaras.readingisgood.restcontroller.order;

import com.aliaras.readingisgood.model.customer.CustomerEntity;
import com.aliaras.readingisgood.model.order.OrderEntity;
import com.aliaras.readingisgood.service.order.IOrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrderRestControllerTest {

    @Mock
    OrderEntity orderEntity;

    @Mock
    CustomerEntity customerEntity;

    @Mock
    IOrderService iOrderService;

    @InjectMocks
    OrderRestController orderRestController;

    @Test
    void getAll() {
        Assertions.assertDoesNotThrow(() -> orderRestController.getAll(customerEntity));
    }

    @Test
    void save() {
        Assertions.assertDoesNotThrow(() -> orderRestController.save(orderEntity));
    }

    @Test
    void delete() {
        Assertions.assertDoesNotThrow(() -> orderRestController.delete(orderEntity));
    }
}