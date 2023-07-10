package lk.ijse.test.service.custom;

import lk.ijse.test.dto.custom.CustomerDTO;
import lk.ijse.test.repo.custom.CustomerRepo;
import lk.ijse.test.repo.util.RepoFactory;
import lk.ijse.test.service.CrudService;
import org.hibernate.Session;

public interface CustomerService extends CrudService<CustomerDTO,Integer> {
    CustomerRepo repo = RepoFactory.getInstance().getRepo(RepoFactory.Type.CUSTOMER);
    public int getCustomerCount();
}
