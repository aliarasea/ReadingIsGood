package com.aliaras.readingisgood.model.order;

import com.aliaras.readingisgood.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderEntity extends BaseEntity {
    private Long orderId;
    private Long customerId;
    private List<Long> bookIdList;
    private Status status;
}
