package lk.ijse.test.dto.custom;

import lk.ijse.test.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO implements SuperDTO {
    private int itemCode;
    private String itemName;
    private String itemPrice;
    private String itemQty;


}
