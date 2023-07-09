package lk.ijse.test.dto.custom;

import lk.ijse.test.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto implements SuperDTO {
    private int id;
    private int qty;
    private OrderDto order;
    private ItemDTO item;
}
