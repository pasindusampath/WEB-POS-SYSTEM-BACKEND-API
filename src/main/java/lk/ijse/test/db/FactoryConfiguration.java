package lk.ijse.test.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration instance;
    private SessionFactory factory;
    private FactoryConfiguration(){
        Configuration configure = new Configuration().configure();
        factory=configure.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance(){
        return instance==null ? instance=new FactoryConfiguration() : instance;
    }

    public Session getSession(){
        return factory.openSession();
    }
}
