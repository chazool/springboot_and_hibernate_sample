package com.chazool.sample.customerservice.dao;

import com.chazool.sample.customerservice.config.HibernateConfiguration;
import com.chazool.sample.customerservice.exception.CustomerNotFountException;
import com.chazool.sample.customerservice.model.Customer;
import org.hibernate.*;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {


    @Override
    public Customer save(Customer customer) {
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        session.save(customer);
        session.close();
        return customer;
    }

    @Override
    public Customer update(Customer customer) throws PersistenceException {
        Transaction transaction = null;
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.update(customer);
        transaction.commit();
        session.close();
        return customer;
    }

    @Override
    public void delete(int id) {
        Transaction transaction = null;
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        if (customer != null) {
            session.delete(customer);
        } else {
            throw new CustomerNotFountException("Couldn't find customer.!");
        }
        transaction.commit();
        session.close();
    }

    @Override
    public Customer fetchById(int id) {
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        Customer customer = (Customer) session.get(Customer.class, id);
        return customer;
    }

    @Override
    public List<Customer> fetchAll() {
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        List<Customer> customerList = session.createQuery("from Customer").list();
        return customerList;
    }
}
