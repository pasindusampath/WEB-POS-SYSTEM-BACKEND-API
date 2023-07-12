package lk.ijse.test.entity.custom;

import lk.ijse.test.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Customer implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String mobileNo;
    private String birthday;
    private String gen;

    @OneToMany(targetEntity = Order.class,mappedBy = "id",cascade = CascadeType.REMOVE)
    private List<Order> orders;

}
