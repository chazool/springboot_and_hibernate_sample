package com.chazool.sample.customerservice.config;

import com.chazool.sample.customerservice.model.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


@Component
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class HibernateConfiguration {


    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {

            Configuration configuration = new Configuration();

            Properties properties = new Properties();
            properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            properties.put(Environment.URL, "jdbc:mysql://localhost:3306/customerDB");
            properties.put(Environment.USER, "root");
            properties.put(Environment.PASS, "1234");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

            properties.put(Environment.SHOW_SQL, "true");

            properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

            properties.put(Environment.HBM2DDL_AUTO, "update");

            configuration.setProperties(properties);

            configuration.addAnnotatedClass(Customer.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        }
        return sessionFactory;
    }

}
