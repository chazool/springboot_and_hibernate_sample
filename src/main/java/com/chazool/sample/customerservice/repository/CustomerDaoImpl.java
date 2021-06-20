package com.chazool.sample.customerservice.repository;

import com.chazool.sample.customerservice.config.HibernateConfiguration;
import com.chazool.sample.customerservice.exception.CustomerNotFountException;
import com.chazool.sample.customerservice.model.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

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
    public Customer update(Customer customer) {
        Transaction transaction = null;
        Session session = HibernateConfiguration.getSessionFactory().openSession();

        // start a transaction
        transaction = session.beginTransaction();
        // save the customer object
        session.update(customer);
        // commit transaction
        transaction.commit();

        if (transaction != null) {
            transaction.rollback();
        }
        session.close();
        return customer;
    }

    @Override
    public void delete(int id) {
        Transaction transaction = null;
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        Customer customer = (Customer) session.load(Customer.class, new Integer(id));
        if (null != customer) {
            session.delete(customer);
        } else {
            throw new CustomerNotFountException("Couldn't find customer.!");
        }
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
