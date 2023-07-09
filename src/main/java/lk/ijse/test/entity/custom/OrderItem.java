package lk.ijse.test.entity.custom;

import lk.ijse.test.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int qty;
    @ManyToOne(cascade = CascadeType.DETACH)
    private Order order;
    @ManyToOne(cascade = CascadeType.DETACH)
    private Item item;
}
