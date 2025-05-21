package abdumalik.dev.radioselectronics.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class YourOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToMany
    private List<Product> product;
    @OneToOne
    private Total subTotal;
    @OneToOne
    private Total total;
    @OneToOne
    private Total shipping;

}