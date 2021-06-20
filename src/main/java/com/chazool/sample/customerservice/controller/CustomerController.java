package com.chazool.sample.customerservice.controller;

import com.chazool.sample.customerservice.exception.CustomerNotFountException;
import com.chazool.sample.customerservice.model.Customer;
import com.chazool.sample.customerservice.model.Response;
import com.chazool.sample.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/services/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Response save(@RequestBody Customer customer) {
        try {
            return Response.success(customerService.save(customer));
        } catch (Exception exception) {
            return Response.fail(exception.getMessage());
        }
    }

    @PutMapping
    public Response update(@RequestBody Customer customer) {
        try {
            return Response.success(customerService.update(customer));
        } catch (CustomerNotFountException customerNotFountException) {
            return Response.fail(customerNotFountException.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public Response delete(@PathVariable int id) {
        try {
            customerService.delete(id);
            return Response.success(true);
        } catch (Exception exception) {
            return Response.fail(exception.getMessage());
        }
    }

    @GetMapping(value = "/{id}")
    public Response fetchById(@PathVariable int id) {
        try {
            return Response.success(customerService.fetchById(id));
        } catch (CustomerNotFountException customerNotFountException) {
            return Response.fail(customerNotFountException.getMessage());
        }
    }

    @GetMapping
    public Response fetchAll() {
        try {
            return Response.success(customerService.fetchAll());
        } catch (Exception exception) {
            return Response.fail(exception.getMessage());
        }
    }


}
