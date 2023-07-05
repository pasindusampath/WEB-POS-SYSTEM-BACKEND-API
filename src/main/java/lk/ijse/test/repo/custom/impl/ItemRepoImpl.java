package lk.ijse.test.repo.custom.impl;

import lk.ijse.test.entity.custome.Item;
import lk.ijse.test.repo.custom.ItemRepo;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public class ItemRepoImpl implements ItemRepo {
    @Override
    public Item add(Session session, Item item) {
        Serializable save = session.save(item);
        item.setItemCode((int) save);
        return item;
    }

    @Override
    public void update(Session session, Item item) {
        session.update(item);
    }

    @Override
    public void delete(Session session, Item item) {
        session.delete(item);
    }

    @Override
    public Item get(Session session, Integer integer) {
        return session.get(Item.class,integer);
    }

    @Override
    public List<Item> getAll(Session session) {
        return session.createQuery("FROM Item").list();
    }
}
