package lk.ijse.test.service.custom.impl;

import lk.ijse.test.dto.custom.CustomerDTO;
import lk.ijse.test.entity.custom.Customer;
import lk.ijse.test.service.custom.CustomerService;
import lk.ijse.test.util.Converter;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDTO add(CustomerDTO customerDTO) {
        Customer convert = Converter.convert(customerDTO);
        Transaction transaction =null;
        try(Session session=factory.getSession();) {
            transaction = session.beginTransaction();
            Customer add = repo.add(session, convert);
            transaction.commit();
            return Converter.convert(add);
        }catch (Exception e){
            if (transaction!=null)
            transaction.rollback();
        }
        return null;
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO) {
        Customer cu = Converter.convert(customerDTO);
        Session session = factory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            repo.update(session,cu);
            transaction.commit();
            return customerDTO;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Session session = factory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Customer customer = repo.get(session, id);
            if(customer!=null){
                repo.delete(session,customer);
                transaction.commit();
                return true;
            }
            transaction.rollback();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public CustomerDTO get(Integer id) {
        try(Session session = factory.getSession()){
            Customer customer = repo.get(session, id);
            if(customer!=null)return Converter.convert(customer);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CustomerDTO> getAll() {
        Session session = factory.getSession();
        List<Customer> all = repo.getAll(session);
        List<CustomerDTO> list = new ArrayList<>();
        all.forEach(c->list.add(new CustomerDTO(c.getId(),c.getName()
                ,c.getAddress(),c.getMobileNo(),c.getBirthday(),c.getGen())));
        return list;
    }

    @Override
    public int getCustomerCount() {
        try(Session session=factory.getSession()) {
            return repo.getCustomerCount(session);
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
}
