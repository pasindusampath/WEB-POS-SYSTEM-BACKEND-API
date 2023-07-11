package lk.ijse.test.service.custom.impl;

import lk.ijse.test.db.FactoryConfiguration;
import lk.ijse.test.dto.custom.OrderDto;
import lk.ijse.test.dto.custom.OrderItemDto;
import lk.ijse.test.entity.custom.Customer;
import lk.ijse.test.entity.custom.Item;
import lk.ijse.test.entity.custom.Order;
import lk.ijse.test.entity.custom.OrderItem;
import lk.ijse.test.repo.custom.ItemRepo;
import lk.ijse.test.repo.custom.OrderItemRepo;
import lk.ijse.test.repo.custom.OrderRepo;
import lk.ijse.test.repo.util.RepoFactory;
import lk.ijse.test.service.custom.OrderService;
import lk.ijse.test.tm.ChartTM;
import lk.ijse.test.tm.LineChartTM;
import lk.ijse.test.util.Converter;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderRepo repo = RepoFactory.getInstance().getRepo(RepoFactory.Type.ORDER);
    private OrderItemRepo oirepo = RepoFactory.getInstance().getRepo(RepoFactory.Type.ORDER_ITEM);
    private ItemRepo irepo = RepoFactory.getInstance().getRepo(RepoFactory.Type.ITEM);
    FactoryConfiguration factory = FactoryConfiguration.getInstance();
    @Override
    public OrderDto add(OrderDto orderDto) {
        Order order = Converter.convert(orderDto);
        Customer customer = Converter.convert(orderDto.getCustomer());
        order.setCustomer(customer);
        Session session = factory.getSession();
        Transaction tra = session.beginTransaction();
        try {
            Order add = repo.add(session, order);

            tra.commit();
            return Converter.convert(add);
        }catch (Exception e){
            tra.rollback();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public OrderDto update(OrderDto orderDto) {
        return null;
    }

    @Override
    public boolean delete(Integer type) {
        return false;
    }

    @Override
    public OrderDto get(Integer type) {
        return null;
    }

    @Override
    public List<OrderDto> getAll() {
        return null;
    }

    @Override
    public boolean add(OrderDto order, List<OrderItemDto> items) {
        Order orderEntity = Converter.convert(order);
        Customer customer = Converter.convert(order.getCustomer());
        orderEntity.setCustomer(customer);
        ArrayList<OrderItem> list = new ArrayList<>();
        ArrayList<Item> itemList = new ArrayList<>();
        items.stream().forEach(e->{
            OrderItem convert1 = Converter.convert(e);
            Item item = Converter.convert(e.getItem());
            itemList.add(item);
            convert1.setOrder(orderEntity);
            convert1.setItem(item);
            list.add(convert1);
        });

        Session session = factory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Order add = repo.add(session, orderEntity);
            oirepo.addAll(list,session);
            boolean flag = irepo.updateQty(session, itemList);
            if(flag){
                transaction.commit();
            }

        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }



        return false;
    }

    @Override
    public int getOrderCount() {
        try (Session session = factory.getSession()) {
            return repo.getOrderCount(session);
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<ChartTM> getMonthlyIncome() {
        List<ChartTM> items = new ArrayList<>();
        try (Session session = factory.getSession()){
            repo.getMonthlyIncome(session).forEach((i,e)->{
                items.add(new ChartTM(Month.of(i).toString(),e));
            });
        }catch (Exception e){
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<LineChartTM> getItemCountForDay() {
        List<LineChartTM> list = new ArrayList<>();
        try(Session session=factory.getSession()) {
            HashMap<Integer, Double> itemCountForDay = repo.getItemCountForDay(session);
            for (int i = 1; i < 13; i++) {
                if(!itemCountForDay.containsKey(i)){
                    itemCountForDay.put(i,0.0);
                }
            }
            itemCountForDay.forEach((i,e)->{
                list.add(new LineChartTM(Month.of(i).toString(),e));
            });
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
