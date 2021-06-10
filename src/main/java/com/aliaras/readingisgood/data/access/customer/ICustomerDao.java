package com.aliaras.readingisgood.data.access.customer;

import com.aliaras.readingisgood.model.customer.CustomerEntity;

public interface ICustomerDao {
    CustomerEntity save(CustomerEntity entity);

    boolean delete(CustomerEntity entity);
}
