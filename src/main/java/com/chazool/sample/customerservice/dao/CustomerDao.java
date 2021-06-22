package com.chazool.sample.customerservice.dao;

import com.chazool.sample.customerservice.model.Customer;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * @author Chzool
 */
public interface CustomerDao {

    /**
     * This method save customer - DB
     *
     * @param customer
     * @return Customer
     */
    public Customer save(Customer customer);

    /**
     * This method update customer - DB
     *
     * @param customer
     * @return Customer
     * @throws PersistenceException
     */
    public Customer update(Customer customer) throws PersistenceException;

    /**
     * This method delete customer - DB
     *
     * @param id
     */
    public void delete(int id);

    /**
     * This method fetch customer using by Id - DB
     *
     * @param id
     * @return Customer
     */
    public Customer fetchById(int id);

    /**
     * This Method fetch All Cutomer - DB
     *
     * @return List<Customer>
     */
    public List<Customer> fetchAll();
}
