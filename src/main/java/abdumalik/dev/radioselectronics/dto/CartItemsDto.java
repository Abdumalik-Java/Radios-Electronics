package abdumalik.dev.radioselectronics.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemsDto {

    private UUID subTotal;
    private UUID productName;
    private UUID productPrice;
    private UUID productId;

}