package lk.ijse.test.util;

import lk.ijse.test.dto.custom.CustomerDTO;
import lk.ijse.test.entity.custome.Customer;
import lk.ijse.test.entity.custome.Item;

public class Converter {
    public static CustomerDTO convert(Customer customer){
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress(),
                customer.getMobileNo(), customer.getBirthday(), customer.getGen());
    }

    public static Customer convert(CustomerDTO customer){
        return new Customer(customer.getId(), customer.getName(), customer.getAddress(),
                customer.getMobileNo(), customer.getBirthday(), customer.getGen());
    }

   // public static Item


}
