package com.aliaras.readingisgood.service.customer.impl;

import com.aliaras.readingisgood.data.access.customer.ICustomerDao;
import com.aliaras.readingisgood.model.customer.CustomerEntity;
import com.aliaras.readingisgood.service.customer.ICustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    ICustomerDao iCustomerDao;

    @Mock
    CustomerEntity customerEntity;

    @InjectMocks
    CustomerService customerService;

    @Mock
    ICustomerService iCustomerService = new CustomerService(iCustomerDao);

    @Test
    void save() {
        Assertions.assertNull(customerService.save(customerEntity));
        Assertions.assertNull(iCustomerService.save(customerEntity));
    }

    @Test
    void delete() {
        Assertions.assertDoesNotThrow(() -> customerService.delete(customerEntity));
        Assertions.assertDoesNotThrow(() -> iCustomerService.delete(customerEntity));
    }
}