package lk.ijse.test.repo.custom;

import lk.ijse.test.entity.custom.OrderItem;
import lk.ijse.test.repo.CrudRepo;
import org.hibernate.Session;

import java.util.List;

public interface OrderItemRepo extends CrudRepo<OrderItem,Integer> {
    public void addAll(List<OrderItem> items, Session session);
}
