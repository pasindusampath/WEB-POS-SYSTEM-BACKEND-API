package lk.ijse.test;

import lk.ijse.test.db.FactoryConfiguration;
import lk.ijse.test.repo.custom.impl.OrderRepoImpl;
import lk.ijse.test.service.custom.impl.OrderServiceImpl;

public class Main {
    public static void main(String[] args) {
        FactoryConfiguration instance = FactoryConfiguration.getInstance();
        System.out.println(new OrderRepoImpl().getOrderCount(instance.getSession()));

    }
}
