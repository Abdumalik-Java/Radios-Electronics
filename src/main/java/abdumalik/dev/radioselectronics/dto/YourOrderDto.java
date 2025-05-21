package abdumalik.dev.radioselectronics.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YourOrderDto {

    private UUID productId;
    private UUID subTotalId;
    private UUID totalId;
    private UUID shippingId;

}