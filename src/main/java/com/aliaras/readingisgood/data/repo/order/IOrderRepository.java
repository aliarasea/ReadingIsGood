package com.aliaras.readingisgood.data.repo.order;

import com.aliaras.readingisgood.model.order.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.sql.Date;
import java.util.List;

public interface IOrderRepository extends MongoRepository<OrderEntity, Long> {
    List<OrderEntity> findByCustomerId(Long customerId);

    List<OrderEntity> findByCreatedAtBetween(Long customerId, Date startDate, Date endDate);
}
