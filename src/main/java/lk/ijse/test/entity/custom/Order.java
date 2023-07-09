package lk.ijse.test.entity.custom;

import lk.ijse.test.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date orderDate;
    private double total;
    @ManyToOne(cascade = CascadeType.DETACH)
    private Customer customer;
    @OneToMany(targetEntity = OrderItem.class,mappedBy = "order")
    private List<OrderItem> list;
}
