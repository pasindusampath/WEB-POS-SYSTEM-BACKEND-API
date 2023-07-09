package lk.ijse.test.repo.custom;

import lk.ijse.test.entity.custom.Item;
import lk.ijse.test.repo.CrudRepo;
import org.hibernate.Session;

import java.util.List;

public interface ItemRepo extends CrudRepo<Item,Integer> {
    public boolean updateQty(Session session, List<Item> items);
}
