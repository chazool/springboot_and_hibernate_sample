package com.chazool.sample.customerservice.service.impl;

import com.chazool.sample.customerservice.exception.CustomerNotFountException;
import com.chazool.sample.customerservice.model.Customer;
import com.chazool.sample.customerservice.dao.CustomerDao;
import com.chazool.sample.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Customer save(Customer customer) {
        return customerDao.save(customer);
    }

    @Override
    public Customer update(Customer customer) throws CustomerNotFountException {
        try {
            return customerDao.update(customer);
        } catch (PersistenceException persistenceException) {
            throw new CustomerNotFountException("Customer Not exist , " + persistenceException.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        customerDao.delete(id);
    }

    @Override
    public Customer fetchById(int id) throws CustomerNotFountException {
        Customer customer = customerDao.fetchById(id);
        if (customer != null) {
            return customer;
        } else {
            throw new CustomerNotFountException("Couldn't find customer.!");
        }
    }

    @Override
    public List<Customer> fetchAll() {
        return customerDao.fetchAll();
    }
}
