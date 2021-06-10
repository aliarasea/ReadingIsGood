package com.aliaras.readingisgood.data.access.order.impl;

import com.aliaras.readingisgood.data.access.order.IOrderDao;
import com.aliaras.readingisgood.data.repo.order.IOrderRepository;
import com.aliaras.readingisgood.model.customer.CustomerEntity;
import com.aliaras.readingisgood.model.order.OrderEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.spy;

@ExtendWith(MockitoExtension.class)
class OrderDaoTest {

    @Mock
    IOrderRepository iOrderRepository;

    @Mock
    OrderEntity orderEntity;

    @Mock
    CustomerEntity customerEntity;

    @InjectMocks
    OrderDao orderDao;

    @Mock
    IOrderDao iOrderDao = new OrderDao(iOrderRepository);

    @Test
    void save() {
        Assertions.assertNull(orderDao.save(orderEntity));
        Assertions.assertNull(iOrderDao.save(orderEntity));
    }

    @Test
    void delete() {
        Assertions.assertDoesNotThrow(() -> orderDao.delete(orderEntity));
        Assertions.assertDoesNotThrow(() -> iOrderDao.delete(orderEntity));

        OrderEntity orderEntity1 = new OrderEntity();
        orderEntity1.setOrderId(Long.MAX_VALUE);

        Mockito.when(iOrderRepository.findById(orderEntity1.getOrderId())).thenReturn(Optional.of(orderEntity1));
        Assertions.assertTrue(orderDao.delete(orderEntity1));

        Mockito.when(iOrderRepository.findById(orderEntity.getOrderId())).thenReturn(Optional.empty());
        Assertions.assertFalse(orderDao.delete(orderEntity));
    }

    @Test
    void getAll() {
        Assertions.assertDoesNotThrow(() -> orderDao.getAll(customerEntity));
    }

    @Test
    void testGetAll0() {
        Assertions.assertDoesNotThrow(() -> orderDao.getAll(customerEntity, Mockito.mock(Date.class), Mockito.mock(Date.class)));
    }

    @Test
    void testGetAll1() {
        ArrayList<Long> orderIdList = new ArrayList<>();
        orderIdList.add(1L);
        orderIdList.add(2L);
        Assertions.assertDoesNotThrow(() -> orderDao.getAll(orderIdList));
    }

    @Test
    void testGetAll2() {
        Assertions.assertDoesNotThrow(() -> orderDao.getAll());
    }
}