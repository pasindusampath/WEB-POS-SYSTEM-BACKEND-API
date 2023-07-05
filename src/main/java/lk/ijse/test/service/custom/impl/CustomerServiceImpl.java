package lk.ijse.test.service.custom.impl;

import lk.ijse.test.db.FactoryConfiguration;
import lk.ijse.test.dto.custom.CustomerDTO;
import lk.ijse.test.entity.custome.Customer;
import lk.ijse.test.repo.custom.impl.CustomerRepoImpl;
import lk.ijse.test.service.custom.CustomerService;
import lk.ijse.test.util.Converter;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerServiceImpl implements CustomerService {
    FactoryConfiguration factory = FactoryConfiguration.getInstance();
    @Override
    public CustomerDTO add(CustomerDTO customerDTO) {
        CustomerRepoImpl customerRepo = new CustomerRepoImpl();
        Customer convert = Converter.convert(customerDTO);
        Transaction transaction =null;
        try(Session session=factory.getSession();) {
            transaction = session.beginTransaction();
            Customer add = customerRepo.add(session, convert);
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
        return null;
    }

    @Override
    public boolean delete(Integer type) {
        return false;
    }

    @Override
    public CustomerDTO get(Integer type) {
        return null;
    }
}
