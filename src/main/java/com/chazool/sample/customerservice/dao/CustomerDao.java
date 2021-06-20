package com.chazool.sample.customerservice.dao;

import com.chazool.sample.customerservice.model.Customer;

import javax.persistence.PersistenceException;
import java.util.List;

public interface CustomerDao {

    public Customer save(Customer customer);

    public Customer update(Customer customer) throws PersistenceException;

    public void delete(int id);

    public Customer fetchById(int id);

    public List<Customer> fetchAll();
}
