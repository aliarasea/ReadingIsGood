package com.aliaras.readingisgood.restcontroller.customer;

import com.aliaras.readingisgood.app.aspect.ReadingIsGoodLogger;
import com.aliaras.readingisgood.model.customer.CustomerEntity;
import com.aliaras.readingisgood.service.customer.ICustomerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/customer")
public class CustomerRestController {

    private final ICustomerService iCustomerService;

    public CustomerRestController(ICustomerService iCustomerService) {
        this.iCustomerService = iCustomerService;
    }

    @ReadingIsGoodLogger
    @PostMapping("/save")
    public ResponseEntity<CustomerEntity> save(@RequestBody CustomerEntity customerEntity) {
        return new ResponseEntity<>(iCustomerService.save(customerEntity), HttpStatus.OK);
    }

    @ReadingIsGoodLogger
    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> delete(@RequestBody CustomerEntity customerEntity) {
        return new ResponseEntity<>(iCustomerService.delete(customerEntity), HttpStatus.OK);
    }
}
