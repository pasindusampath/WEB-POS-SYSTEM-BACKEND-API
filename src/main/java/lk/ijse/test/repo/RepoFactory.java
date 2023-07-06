package lk.ijse.test.repo;

import lk.ijse.test.repo.custom.CustomerRepo;
import lk.ijse.test.repo.custom.ItemRepo;
import lk.ijse.test.repo.custom.impl.CustomerRepoImpl;
import lk.ijse.test.repo.custom.impl.ItemRepoImpl;

public class RepoFactory {
    public enum Type{
        CUSTOMER,ITEM
    }
    private static RepoFactory factory;
    private CustomerRepo customer;
    private ItemRepo item;

    private RepoFactory(){
        customer=new CustomerRepoImpl();
        item=new ItemRepoImpl();
    }

    public static RepoFactory getInstance(){
        return factory==null ? factory = new RepoFactory():factory;
    }

    public <T>T getRepo(Type type){
        switch (type){
            case CUSTOMER:return (T)customer;
            case ITEM:return (T)item;
            default:return null;
        }
    }

}
