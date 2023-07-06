package lk.ijse.test.service.util;

import lk.ijse.test.service.SuperService;
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

    public static ServiceFactory getInstance(){
        return factory==null ? factory=new ServiceFactory() : factory;
    }

    public <T extends SuperService>T getService(Type type){
        switch (type){
            case ITEM:return (T) itemService;
            case CUSTOMER:return (T)customerService;
            default:return null;
        }
    }



}
