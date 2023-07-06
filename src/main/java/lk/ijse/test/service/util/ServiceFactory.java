package lk.ijse.test.service.util;

import lk.ijse.test.service.custom.CustomerService;
import lk.ijse.test.service.custom.ItemService;
import lk.ijse.test.service.custom.impl.CustomerServiceImpl;
import lk.ijse.test.service.custom.impl.ItemServiceImpl;

public class ServiceFactory {
    public enum Type{
        CUSTOMER,ITEM
    }
    private static ServiceFactory factory;
    private CustomerService customerService;
    private ItemService itemService;

    private ServiceFactory(){
        customerService=new CustomerServiceImpl();
        itemService=new ItemServiceImpl();
    }



}
