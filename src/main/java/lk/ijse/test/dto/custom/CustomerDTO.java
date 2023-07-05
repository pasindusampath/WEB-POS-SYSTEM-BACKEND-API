package lk.ijse.test.dto.custom;


import lk.ijse.test.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO implements SuperDTO {
    private int id;
    private String name;
    private String address;
    private String mobileNo;
    private String birthday;
    private String gen;
}
