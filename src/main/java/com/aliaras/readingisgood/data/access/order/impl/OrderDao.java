package com.aliaras.readingisgood.data.access.order.impl;

import com.aliaras.readingisgood.data.access.order.IOrderDao;
import com.aliaras.readingisgood.data.repo.order.IOrderRepository;
import com.aliaras.readingisgood.model.customer.CustomerEntity;
import com.aliaras.readingisgood.model.order.OrderEntity;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class OrderDao implements IOrderDao {

    private final IOrderRepository iOrderRepository;

    public OrderDao(IOrderRepository iOrderRepository) {
        this.iOrderRepository = iOrderRepository;
    }


    @Override
    public List<OrderEntity> getAll() {
        return iOrderRepository.findAll();
    }

    @Override
    public List<OrderEntity> getAll(CustomerEntity customerEntity) {
        return iOrderRepository.findByCustomerId(customerEntity.getCustomerId());
    }

    @Override
    public List<OrderEntity> getAll(List<Long> orderIdList) {
        return ((List<OrderEntity>) iOrderRepository.findAllById(orderIdList));
    }


    @Override
    public List<OrderEntity> getAll(CustomerEntity customerEntity, Date startDate, Date endDate) {
        return iOrderRepository.findByCreatedAtBetween(customerEntity.getCustomerId(), startDate, endDate);
    }

    @Override
    public OrderEntity save(OrderEntity orderEntity) {
        return iOrderRepository.save(orderEntity);
    }

    @Override
    public boolean delete(OrderEntity orderEntity) {
        boolean exist = iOrderRepository.findById(orderEntity.getOrderId()).isPresent();
        if (exist) {
            iOrderRepository.delete(orderEntity);
            return true;
        }
        return false;
    }
}
