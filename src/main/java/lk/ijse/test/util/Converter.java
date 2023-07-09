package lk.ijse.test.util;

import lk.ijse.test.dto.custom.CustomerDTO;
import lk.ijse.test.dto.custom.ItemDTO;
import lk.ijse.test.dto.custom.OrderDto;
import lk.ijse.test.dto.custom.OrderItemDto;
import lk.ijse.test.entity.custom.Customer;
import lk.ijse.test.entity.custom.Item;
import lk.ijse.test.entity.custom.Order;
import lk.ijse.test.entity.custom.OrderItem;

import java.sql.Date;

public class Converter {
    public static CustomerDTO convert(Customer customer){
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress(),
                customer.getMobileNo(), customer.getBirthday(), customer.getGen());
    }

    public static Customer convert(CustomerDTO customer){
        return new Customer(customer.getId(), customer.getName(), customer.getAddress(),
                customer.getMobileNo(), customer.getBirthday(), customer.getGen(),null);
    }

    public static Item convert(ItemDTO item) {
        return new Item(item.getItemCode(), item.getItemName(), item.getItemPrice(), item.getItemQty(),null);
    }

    public static ItemDTO convert(Item item) {
        return new ItemDTO(item.getItemCode(), item.getItemName(), item.getItemPrice(), item.getItemQty());
    }

    //public static Item
    public static Order convert(OrderDto ob){
        return new Order(ob.getId(), Date.valueOf(ob.getDate()),ob.getTotal(),null,null);
    }

    public static OrderDto convert(Order ob){
        return new OrderDto(ob.getId(), ob.getOrderDate().toLocalDate(),ob.getTotal(),null);
    }

    public static OrderItemDto convert(OrderItem ob){
        return new OrderItemDto(ob.getId(), ob.getQty(), null,null);
    }

    public static OrderItem convert(OrderItemDto ob){
        return new OrderItem(ob.getId(), ob.getQty(), null,null);
    }

}
