package lk.ijse.test.dto.custom;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private int id;
    private String name;
    private String address;
    private String mobileNo;
    private String birthday;
    private String gen;
}
