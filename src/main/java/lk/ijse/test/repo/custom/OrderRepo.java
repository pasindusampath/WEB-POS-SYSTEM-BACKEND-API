package lk.ijse.test.repo.custom;

import lk.ijse.test.entity.custom.Order;
import lk.ijse.test.repo.CrudRepo;
import org.hibernate.Session;

public interface OrderRepo extends CrudRepo<Order,Integer> {
    public int getOrderCount(Session session);
}
