package com.aliaras.readingisgood.service.customer.impl;

import com.aliaras.readingisgood.app.aspect.ReadingIsGoodLogger;
import com.aliaras.readingisgood.data.access.customer.ICustomerDao;
import com.aliaras.readingisgood.model.customer.CustomerEntity;
import com.aliaras.readingisgood.service.customer.ICustomerService;
import com.aliaras.readingisgood.service.customer.util.CustomerUtil;
import lombok.Synchronized;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    private final ICustomerDao iCustomerDao;

    public CustomerService(ICustomerDao iCustomerDao) {
        this.iCustomerDao = iCustomerDao;
    }

    @ReadingIsGoodLogger
    @Synchronized
    @Override
    public CustomerEntity save(CustomerEntity customerEntity) {
        CustomerUtil.setCustomerId(customerEntity);
        return iCustomerDao.save(customerEntity);
    }

    @ReadingIsGoodLogger
    @Synchronized
    @Override
    public boolean delete(CustomerEntity customerEntity) {
        return true;
    }
}
