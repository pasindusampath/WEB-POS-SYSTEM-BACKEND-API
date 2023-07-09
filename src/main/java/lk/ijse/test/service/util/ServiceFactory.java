package lk.ijse.test.service.util;

import lk.ijse.test.service.SuperService;
import lk.ijse.test.service.custom.CustomerService;
import lk.ijse.test.service.custom.ItemService;
import lk.ijse.test.service.custom.OrderService;
import lk.ijse.test.service.custom.impl.CustomerServiceImpl;
import lk.ijse.test.service.custom.impl.ItemServiceImpl;
import lk.ijse.test.service.custom.impl.OrderServiceImpl;

public class ServiceFactory {
    public enum Type{
        CUSTOMER,ITEM,ORDER
    }
    private static ServiceFactory factory;
    private CustomerService customerService;
    private ItemService itemService;
    private OrderService orderService;

    private ServiceFactory(){
        customerService=new CustomerServiceImpl();
        itemService=new ItemServiceImpl();
        orderService=new OrderServiceImpl();
    }

    public static ServiceFactory getInstance(){
        return factory==null ? factory=new ServiceFactory() : factory;
    }

    public <T extends SuperService>T getService(Type type){
        switch (type){
            case ITEM:return (T) itemService;
            case CUSTOMER:return (T)customerService;
            case ORDER:return (T)orderService;
            default:return null;
        }
    }



}
