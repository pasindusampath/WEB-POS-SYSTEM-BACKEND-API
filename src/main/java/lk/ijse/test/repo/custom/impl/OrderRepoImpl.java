package lk.ijse.test.repo.custom.impl;

import lk.ijse.test.entity.custom.Order;
import lk.ijse.test.repo.custom.OrderRepo;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

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

    @Override
    public int getOrderCount(Session session){
        return Integer.parseInt(session.createQuery("SELECT count(*) FROM orders o where Month(o.orderDate)="+LocalDate.now().getMonthValue() ).getSingleResult().toString());
    }

    @Override
    public HashMap<Integer,Double> getMonthlyIncome(Session session){
        Query query = session.createQuery("SELECT MONTH(o.orderDate) ,sum(o.total) FROM orders o WHERE Year(o.orderDate) = :year GROUP BY MONTH(o.orderDate)",Object[].class);
        query.setParameter("year",LocalDate.now().getYear());
        //List list = query.list();
        HashMap<Integer, Double> map = new HashMap<>();
        query.getResultStream().forEach(o -> {
           map.put(Integer.parseInt(((Object[]) o)[0].toString()),Double.parseDouble(((Object[]) o)[1].toString()));
        });
        return map;
    }

    @Override
    public HashMap<Integer, Double> getItemCountForDay(Session session){
        Query<Object[]> query = session.createQuery("SELECT SUM(oi.qty),Month(oi.order.orderDate) FROM OrderIt" +
                "em oi where Year(oi.order.orderDate)=:year group by Month(oi.order.orderDate)", Object[].class);
        query.setParameter("year",LocalDate.now().getYear());
        List<Object[]> list = query.list();
        System.out.println(list);
        HashMap<Integer, Double> hm = new HashMap<>();
        list.stream().forEach((objects -> {
            hm.put(Integer.parseInt(objects[1].toString()),Double.parseDouble(objects[0].toString()));
        }));
        return hm;
    }

}
