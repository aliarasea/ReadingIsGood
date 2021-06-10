package com.aliaras.readingisgood.model.customer;

import com.aliaras.readingisgood.model.base.BaseEntity;
import com.aliaras.readingisgood.model.order.OrderEntity;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class CustomerEntity extends BaseEntity {

    private Long customerId;

    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    @NotNull
    @Email(message = "Email is not valid.")
    private String email;

    private List<OrderEntity> orders;
}
