package com.aliaras.readingisgood.service.customer;

import com.aliaras.readingisgood.model.customer.CustomerEntity;

public interface ICustomerService {
    CustomerEntity save(CustomerEntity customerEntity);

    boolean delete(CustomerEntity customerEntity);
}
