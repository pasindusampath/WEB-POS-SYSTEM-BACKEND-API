package lk.ijse.test.entity.custom;

import lk.ijse.test.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item implements SuperEntity {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemCode;
    private String itemName;
    private double itemPrice;
    private int itemQty;

    @OneToMany(targetEntity = OrderItem.class,mappedBy = "item",cascade = CascadeType.REMOVE)
    private List<OrderItem> list;
}
