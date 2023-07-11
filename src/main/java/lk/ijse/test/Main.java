package lk.ijse.test;

import lk.ijse.test.db.FactoryConfiguration;
import lk.ijse.test.repo.custom.impl.OrderRepoImpl;
import lk.ijse.test.service.custom.impl.OrderServiceImpl;

import java.time.Month;

public class Main {
    public static void main(String[] args) {
        FactoryConfiguration instance = FactoryConfiguration.getInstance();
        //System.out.println(new OrderRepoImpl().getOrderCount(instance.getSession()));
        new OrderRepoImpl().getItemCountForDay(instance.getSession());
        //Month m = Month.of(1);
        //System.out.println(m.toString());
    }
}
