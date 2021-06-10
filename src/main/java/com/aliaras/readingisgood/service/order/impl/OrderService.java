package com.aliaras.readingisgood.service.order.impl;

import com.aliaras.readingisgood.app.aspect.ReadingIsGoodLogger;
import com.aliaras.readingisgood.data.access.order.IOrderDao;
import com.aliaras.readingisgood.model.customer.CustomerEntity;
import com.aliaras.readingisgood.model.order.OrderEntity;
import com.aliaras.readingisgood.service.order.IOrderService;
import com.aliaras.readingisgood.service.order.util.OrderUtil;
import lombok.Synchronized;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    private final IOrderDao iOrderDao;
    private final OrderUtil orderUtil;

    public OrderService(IOrderDao iOrderDao, OrderUtil orderUtil) {
        this.iOrderDao = iOrderDao;
        this.orderUtil = orderUtil;
    }

    @ReadingIsGoodLogger
    @Override
    public List<OrderEntity> getAll(){
        return iOrderDao.getAll();
    }

    @ReadingIsGoodLogger
    @Override
    public List<OrderEntity> getAll(CustomerEntity customerEntity){
        return iOrderDao.getAll(customerEntity);
    }

    @ReadingIsGoodLogger
    @Override
    public List<OrderEntity> getAll(CustomerEntity customerEntity,Date startDate, Date endDate){
        return iOrderDao.getAll(customerEntity);
    }

    @ReadingIsGoodLogger
    @Override
    public List<OrderEntity> getAll(List<Long> orderIdList){
        return iOrderDao.getAll(orderIdList);
    }

    @ReadingIsGoodLogger
    @Synchronized
    @Override
    @Transactional
    public OrderEntity save(OrderEntity orderEntity) {
        orderUtil.setOrderId(orderEntity);
        OrderEntity order = iOrderDao.save(orderEntity);
        orderUtil.decreaseBookStock(orderEntity.getBookIdList());
        return order;
    }

    @ReadingIsGoodLogger
    @Synchronized
    @Override
    @Transactional
    public boolean delete(OrderEntity orderEntity) {
        boolean result = iOrderDao.delete(orderEntity);
        orderUtil.increaseBookStock(orderEntity.getBookIdList());
        return result;
    }
}
