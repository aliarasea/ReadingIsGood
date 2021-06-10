package com.aliaras.readingisgood.data.access.customer.impl;

import com.aliaras.readingisgood.data.access.customer.ICustomerDao;
import com.aliaras.readingisgood.data.repo.customer.ICustomerRepository;
import com.aliaras.readingisgood.model.customer.CustomerEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerDaoTest {

    @Mock
    ICustomerRepository iCustomerRepository;

    @Mock
    CustomerEntity customerEntity;

    @InjectMocks
    CustomerDao customerDao;

    @Mock
    ICustomerDao iCustomerDao = new CustomerDao(iCustomerRepository);


    @Test
    void save() {
        when(customerEntity.getCustomerId()).thenReturn(Long.MAX_VALUE);
        Assertions.assertDoesNotThrow(() -> customerDao.save(customerEntity));
        Assertions.assertDoesNotThrow(() -> iCustomerDao.save(customerEntity));
    }

    @Test
    void delete() {
        when(customerEntity.getCustomerId()).thenReturn(Long.MAX_VALUE);
        Assertions.assertDoesNotThrow(() -> customerDao.delete(customerEntity));
        Assertions.assertDoesNotThrow(() -> iCustomerDao.delete(customerEntity));
    }
}