package lk.ijse.test.repo.custom;


import lk.ijse.test.entity.custom.Customer;
import lk.ijse.test.repo.CrudRepo;
import org.hibernate.Session;


public interface CustomerRepo extends CrudRepo<Customer,Integer> {
    public int getCustomerCount(Session session);
}
