package lk.ijse.test.entity.custome;

import lk.ijse.test.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item implements SuperEntity {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemCode;
    private String itemName;
    private String itemPrice;
    private String itemQty;
}
