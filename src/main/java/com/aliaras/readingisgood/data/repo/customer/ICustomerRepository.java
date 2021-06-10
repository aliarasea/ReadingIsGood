package com.aliaras.readingisgood.data.repo.customer;

import com.aliaras.readingisgood.model.customer.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICustomerRepository extends MongoRepository<CustomerEntity, Long> {
}
