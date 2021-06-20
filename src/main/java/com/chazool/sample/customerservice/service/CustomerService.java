package com.chazool.sample.customerservice.service;

import com.chazool.sample.customerservice.model.Customer;

import java.util.List;

public interface CustomerService {

    public Customer save(Customer customer);

    public Customer update(Customer customer);

    public void delete(int id);

    public Customer fetchById(int id);

    public List<Customer> fetchAll();

}
