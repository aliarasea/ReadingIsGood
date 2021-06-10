package com.aliaras.readingisgood.service.order;

import com.aliaras.readingisgood.model.customer.CustomerEntity;
import com.aliaras.readingisgood.model.order.OrderEntity;

import java.sql.Date;
import java.util.List;

public interface IOrderService {

    List<OrderEntity> getAll();

    List<OrderEntity> getAll(CustomerEntity customerEntity);

    List<OrderEntity> getAll(List<Long> orderIdList);

    List<OrderEntity> getAll(CustomerEntity customerEntity, Date startDate, Date endDate);

    OrderEntity save(OrderEntity orderEntity);

    boolean delete(OrderEntity orderEntity);
}
