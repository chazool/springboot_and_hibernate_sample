package com.chazool.sample.customerservice.service;

import com.chazool.sample.customerservice.model.Customer;

import java.util.List;

/**
 * @author chazool
 */
public interface CustomerService {

    /**
     * This method save customer
     *
     * @param customer
     * @return Customer
     */
    public Customer save(Customer customer);

    /**
     * This method update customer
     *
     * @param customer
     * @return Customer
     */
    public Customer update(Customer customer);

    /**
     * This method delete customer
     * @param id
     */
    public void delete(int id);

    /**
     * This method fetch customer using by id
     * @param id
     * @return Customer
     */
    public Customer fetchById(int id);

    /**
     * This method using fetch all cutomer
     * @return List<Customer>
     */
    public List<Customer> fetchAll();

}
