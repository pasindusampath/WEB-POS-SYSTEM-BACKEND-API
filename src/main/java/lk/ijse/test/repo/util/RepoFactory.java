package lk.ijse.test.repo.util;

import lk.ijse.test.repo.custom.CustomerRepo;
import lk.ijse.test.repo.custom.ItemRepo;
import lk.ijse.test.repo.custom.OrderItemRepo;
import lk.ijse.test.repo.custom.OrderRepo;
import lk.ijse.test.repo.custom.impl.CustomerRepoImpl;
import lk.ijse.test.repo.custom.impl.ItemRepoImpl;
import lk.ijse.test.repo.custom.impl.OrderItemRepoImpl;
import lk.ijse.test.repo.custom.impl.OrderRepoImpl;

public class RepoFactory {
    public enum Type{
        CUSTOMER,ITEM,ORDER,ORDER_ITEM
    }
    private static RepoFactory factory;
    private CustomerRepo customer;
    private ItemRepo item;
    private OrderRepo order;
    private OrderItemRepo orderItem;

    private RepoFactory(){
        customer=new CustomerRepoImpl();
        item=new ItemRepoImpl();
        order=new OrderRepoImpl();
        orderItem=new OrderItemRepoImpl();
    }

    public static RepoFactory getInstance(){
        return factory==null ? factory = new RepoFactory():factory;
    }

    public <T>T getRepo(Type type){
        switch (type){
            case CUSTOMER:return (T)customer;
            case ITEM:return (T)item;
            case ORDER:return (T)order;
            case ORDER_ITEM:return (T)orderItem;
            default:return null;
        }
    }

}
