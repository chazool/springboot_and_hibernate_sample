package com.chazool.sample.customerservice.service.impl;

import com.chazool.sample.customerservice.exception.CustomerNotFountException;
import com.chazool.sample.customerservice.model.Customer;
import com.chazool.sample.customerservice.repository.CustomerDao;
import com.chazool.sample.customerservice.repository.CustomerRepository;
import com.chazool.sample.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    //  @Autowired
    //  private CustomerRepository customerRepository;

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Customer save(Customer customer) {

        //return customerRepository.save(customer);
        return customerDao.save(customer);
    }

    @Override
    public Customer update(Customer customer) throws CustomerNotFountException {
        return customerDao.update(customer);
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
        //  return customerRepository.findAll();
        return customerDao.fetchAll();
    }
}
