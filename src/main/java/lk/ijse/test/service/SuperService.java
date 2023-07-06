package lk.ijse.test.service;

import lk.ijse.test.db.FactoryConfiguration;

public interface SuperService {
    FactoryConfiguration factory = FactoryConfiguration.getInstance();
}
