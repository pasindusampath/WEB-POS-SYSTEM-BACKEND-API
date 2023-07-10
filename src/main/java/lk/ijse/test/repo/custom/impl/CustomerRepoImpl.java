package lk.ijse.test.repo.custom.impl;

import lk.ijse.test.entity.custom.Customer;
import lk.ijse.test.repo.custom.CustomerRepo;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public class CustomerRepoImpl implements CustomerRepo {
    @Override
    public Customer add(Session session, Customer customer) {
        Serializable save = session.save(customer);
        customer.setId((int) save);
        return customer;
    }

    @Override
    public void update(Session session, Customer customer) {
        session.update(customer);
    }

    @Override
    public void delete(Session session, Customer customer) {
        session.delete(customer);
    }

    @Override
    public Customer get(Session session, Integer id) {
        return session.get(Customer.class,id);
    }

    @Override
    public List<Customer> getAll(Session session) {
        return session.createQuery("FROM Customer").list();
    }

    @Override
    public int getCustomerCount(Session session){
        return Integer.parseInt(session.createQuery("SELECT COUNT(*) FROM Customer").getSingleResult().toString());
    }
}
