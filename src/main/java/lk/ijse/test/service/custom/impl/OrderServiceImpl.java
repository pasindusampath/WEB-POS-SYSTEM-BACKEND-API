package lk.ijse.test.service.custom.impl;

import lk.ijse.test.db.FactoryConfiguration;
import lk.ijse.test.dto.custom.OrderDto;
import lk.ijse.test.entity.custom.Customer;
import lk.ijse.test.entity.custom.Order;
import lk.ijse.test.repo.custom.OrderRepo;
import lk.ijse.test.repo.util.RepoFactory;
import lk.ijse.test.service.custom.OrderService;
import lk.ijse.test.util.Converter;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderRepo repo = RepoFactory.getInstance().getRepo(RepoFactory.Type.ORDER);
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
}
