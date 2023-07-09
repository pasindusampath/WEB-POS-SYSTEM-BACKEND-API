package lk.ijse.test.dto.custom;

import lk.ijse.test.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto implements SuperDTO {
    private int id;
    private LocalDate date;
    private double total;
    private CustomerDTO customer;
}
