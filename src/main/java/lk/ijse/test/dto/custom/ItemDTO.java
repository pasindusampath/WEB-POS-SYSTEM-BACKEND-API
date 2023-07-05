package lk.ijse.test.dto.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    private int itemCode;
    private String itemName;
    private String itemPrice;
    private String itemQty;
}
