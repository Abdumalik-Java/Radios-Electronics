package abdumalik.dev.radioselectronics.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutDto {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private String companyName;

}