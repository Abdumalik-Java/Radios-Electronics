package abdumalik.dev.radioselectronics.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {

    private Integer cardNumber;
    private LocalDateTime expiryDate;
    private Long cvvNumber;

}