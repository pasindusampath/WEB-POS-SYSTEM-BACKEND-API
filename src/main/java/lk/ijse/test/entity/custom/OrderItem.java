package lk.ijse.test.entity.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    @Id
    private int id;
    private int qty;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Customer customer;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Item item;
}
