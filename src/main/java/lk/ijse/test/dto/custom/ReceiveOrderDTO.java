package lk.ijse.test.dto.custom;

import lk.ijse.test.tm.CartTM;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiveOrderDTO {
    private CustomerDTO customer;
    private CartTM[] cartItems;
}
