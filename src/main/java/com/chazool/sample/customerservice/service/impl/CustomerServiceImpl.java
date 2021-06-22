package com.chazool.sample.customerservice.service.impl;

import com.chazool.sample.customerservice.exception.CustomerNotFountException;
import com.chazool.sample.customerservice.model.Customer;
import com.chazool.sample.customerservice.dao.CustomerDao;
import com.chazool.sample.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * @author chazool
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    /**
     * {@inheritDoc}
     *
     * @param customer
     * @return Customer
     */
    @Override
    public Customer save(Customer customer) {
        return customerDao.save(customer);
    }

    /**
     * {@inheritDoc}
     *
     * @param customer
     * @return Customer
     * @throws CustomerNotFountException
     */
    @Override
    public Customer update(Customer customer) throws CustomerNotFountException {
        try {
            return customerDao.update(customer);
        } catch (PersistenceException persistenceException) {
            throw new CustomerNotFountException("Customer Not exist , " + persistenceException.getMessage());
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param id
     * @throws CustomerNotFountException
     */
    @Override
    public void delete(int id) throws CustomerNotFountException {
        customerDao.delete(id);
    }

    /**
     * {@inheritDoc}
     *
     * @param id
     * @return Customer
     * @throws CustomerNotFountException
     */
    @Override
    public Customer fetchById(int id) throws CustomerNotFountException {
        Customer customer = customerDao.fetchById(id);
        if (customer != null) {
            return customer;
        } else {
            throw new CustomerNotFountException("Couldn't find customer.!");
        }
    }

    /**
     * {@inheritDoc}
     *
     * @return List<Customer>l
     */
    @Override
    public List<Customer> fetchAll() {
        return customerDao.fetchAll();
    }
}
