package lk.ijse.test.db;

import lk.ijse.test.entity.custom.Customer;
import lk.ijse.test.entity.custom.Item;
import lk.ijse.test.entity.custom.Order;
import lk.ijse.test.entity.custom.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration instance;
    private SessionFactory factory;
    private FactoryConfiguration(){
        Configuration configure = new Configuration().configure().addAnnotatedClass(Customer.class).
                addAnnotatedClass(Item.class).addAnnotatedClass(Order.class).addAnnotatedClass(OrderItem.class);
        factory=configure.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance(){
        return instance==null ? instance=new FactoryConfiguration() : instance;
    }

    public Session getSession(){
        return factory.openSession();
    }
}
