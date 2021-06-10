package com.aliaras.readingisgood.data.access.customer.impl;

import com.aliaras.readingisgood.data.access.customer.ICustomerDao;
import com.aliaras.readingisgood.data.repo.customer.ICustomerRepository;
import com.aliaras.readingisgood.model.customer.CustomerEntity;
import org.springframework.stereotype.Repository;

import java.time.Clock;

@Repository
public class CustomerDao implements ICustomerDao {
    private final ICustomerRepository iCustomerRepository;

    public CustomerDao(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }

    @Override
    public CustomerEntity save(CustomerEntity customerEntity) {
        boolean exist = iCustomerRepository.findById(customerEntity.getCustomerId()).isPresent();
        if (!exist) {
            customerEntity.setCreatedAt(Clock.systemDefaultZone().instant());
        } else {
            customerEntity.setModifiedAt(Clock.systemDefaultZone().instant());
        }
        return iCustomerRepository.save(customerEntity);
    }

    @Override
    public boolean delete(CustomerEntity customerEntity) {
        boolean exist = iCustomerRepository.findById(customerEntity.getCustomerId()).isPresent();
        if (exist) {
            iCustomerRepository.delete(customerEntity);
            return true;
        }
        return false;
    }
}
