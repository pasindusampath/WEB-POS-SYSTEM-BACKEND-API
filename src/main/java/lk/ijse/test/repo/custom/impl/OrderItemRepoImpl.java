package lk.ijse.test.repo.custom.impl;

import lk.ijse.test.entity.custom.OrderItem;
import lk.ijse.test.repo.custom.OrderItemRepo;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public class OrderItemRepoImpl implements OrderItemRepo {
    @Override
    public OrderItem add(Session session, OrderItem orderItem) {
        Serializable save = session.save(orderItem);
        orderItem.setId((int)save);
        return orderItem;
    }

    @Override
    public void update(Session session, OrderItem orderItem) {

    }

    @Override
    public void delete(Session session, OrderItem orderItem) {

    }

    @Override
    public OrderItem get(Session session, Integer integer) {
        return null;
    }

    @Override
    public List<OrderItem> getAll(Session session) {
        return null;
    }

    @Override
    public void addAll(List<OrderItem> items, Session session) {
        for (OrderItem ob :items) {
            this.add(session,ob);
        }
    }
}
