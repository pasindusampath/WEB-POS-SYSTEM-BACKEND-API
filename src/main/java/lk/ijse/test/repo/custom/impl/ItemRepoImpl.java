package lk.ijse.test.repo.custom.impl;

import lk.ijse.test.entity.custom.Item;
import lk.ijse.test.repo.custom.ItemRepo;
import org.hibernate.Session;
import org.hibernate.query.Query;

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


    private boolean updateQty(Session session,Item item){
        Query query = session.createQuery("update Item i set i.itemQty = i.itemQty-:qty where i.id = :id");
        query.setParameter("qty",item.getItemQty());
        query.setParameter("id",item.getItemCode());
        return 0<query.executeUpdate();
    }

    @Override
    public boolean updateQty(Session session,List<Item> items){
        for (Item item : items) {
            if(!updateQty(session,item)){
                return false;
            }
        }
        return true;
    }

}
