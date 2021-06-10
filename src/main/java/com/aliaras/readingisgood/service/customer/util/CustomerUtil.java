package com.aliaras.readingisgood.service.customer.util;

import com.aliaras.readingisgood.model.customer.CustomerEntity;

import java.time.Instant;

public class CustomerUtil {
    public static void setCustomerId(CustomerEntity customerEntity) {
        if (null == customerEntity.getCustomerId()) {
            customerEntity.setCustomerId(Instant.now().toEpochMilli());
        }
    }
}
