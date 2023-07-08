package lk.ijse.test.util;

import lk.ijse.test.dto.custom.CustomerDTO;
import lk.ijse.test.dto.custom.ItemDTO;
import lk.ijse.test.entity.custom.Customer;
import lk.ijse.test.entity.custom.Item;

public class Converter {
    public static CustomerDTO convert(Customer customer){
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress(),
                customer.getMobileNo(), customer.getBirthday(), customer.getGen());
    }

    public static Customer convert(CustomerDTO customer){
        return new Customer(customer.getId(), customer.getName(), customer.getAddress(),
                customer.getMobileNo(), customer.getBirthday(), customer.getGen());
    }

    public static Item convert(ItemDTO item) {
        return new Item(item.getItemCode(), item.getItemName(), item.getItemPrice(), item.getItemQty());
    }

    public static ItemDTO convert(Item item) {
        return new ItemDTO(item.getItemCode(), item.getItemName(), item.getItemPrice(), item.getItemQty());
    }

    // public static Item


}
