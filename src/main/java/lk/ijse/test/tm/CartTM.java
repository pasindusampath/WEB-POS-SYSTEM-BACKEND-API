package lk.ijse.test.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartTM {
    private int itemCode;
    private String itemName;
    private double itemPrice;
    private int itemQty;
    private double itemSubtotal;
}
