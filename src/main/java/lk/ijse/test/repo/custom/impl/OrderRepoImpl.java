package lk.ijse.test.repo.custom.impl;

import lk.ijse.test.entity.custom.Order;
import lk.ijse.test.repo.custom.OrderRepo;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public class OrderRepoImpl implements OrderRepo {
    @Override
    public Order add(Session session, Order order) {
        Serializable save = session.save(order);
        order.setId((int) save);
        return order;
    }

    @Override
    public void update(Session session, Order order) {

    }

    @Override
    public void delete(Session session, Order order) {

    }

    @Override
    public Order get(Session session, Integer integer) {
        return null;
    }

    @Override
    public List<Order> getAll(Session session) {
        return null;
    }
}
