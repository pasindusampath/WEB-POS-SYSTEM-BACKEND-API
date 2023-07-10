package lk.ijse.test.service.custom.impl;

import lk.ijse.test.dto.custom.ItemDTO;
import lk.ijse.test.entity.custom.Item;
import lk.ijse.test.service.custom.ItemService;
import lk.ijse.test.util.Converter;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


public class ItemServiceImpl implements ItemService {

    @Override
    public ItemDTO add(ItemDTO itemDTO) {
        Session session = factory.getSession();
        Item item=Converter.convert(itemDTO);
        Transaction transaction = session.beginTransaction();
        try{
            Item add = repo.add(session, item);
            transaction.commit();
            return Converter.convert(add);
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public ItemDTO update(ItemDTO itemDTO) {
        Session session = factory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            repo.update(session,Converter.convert(itemDTO));
            transaction.commit();
            return itemDTO;
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Session session = factory.getSession();
        Item item = repo.get(session, id);
        Transaction transaction = session.beginTransaction();
        try {
            if(item!=null){
                repo.delete(session,item);
                transaction.commit();
                return true;
            }
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public ItemDTO get(Integer id) {
        Session session = factory.getSession();
        Item item = repo.get(session, id);
        if(item!=null){
            return Converter.convert(item);
        }
        return null;
    }

    @Override
    public List<ItemDTO> getAll() {
        List<ItemDTO> list = new ArrayList<>();
        try (Session session = factory.getSession();){
            List<Item> all = repo.getAll(session);
            for (Item ob : all) {
                list.add(Converter.convert(ob));
            }
        }
        return list;
    }



}
