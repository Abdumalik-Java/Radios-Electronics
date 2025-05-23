package abdumalik.dev.radioselectronics.service;

import abdumalik.dev.radioselectronics.dto.YourOrderDto;
import abdumalik.dev.radioselectronics.model.Product;
import abdumalik.dev.radioselectronics.model.Result;
import abdumalik.dev.radioselectronics.model.Total;
import abdumalik.dev.radioselectronics.model.YourOrder;
import abdumalik.dev.radioselectronics.repository.ProductRepo;
import abdumalik.dev.radioselectronics.repository.TotalRepo;
import abdumalik.dev.radioselectronics.repository.YourOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class YourOrderService {

    @Autowired
    YourOrderRepo repo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    TotalRepo totalRepo;

    public List<YourOrder> findAll() {
        return repo.findAll();
    }

    public YourOrder findById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(YourOrderDto dto) {
        YourOrder yourOrder = new YourOrder();

        Optional<Product> byId = productRepo.findById(dto.getProductId());
        Product product = byId.get();
        yourOrder.setProduct((List<Product>) product);

        Optional<Total> byId1 = totalRepo.findById(dto.getSubTotalId());
        Total subTotal = byId1.get();
        yourOrder.setSubTotal(subTotal);

        Optional<Total> byId2 = totalRepo.findById(dto.getTotalId());
        Total total = byId2.get();
        yourOrder.setTotal(total);

        Optional<Total> byId3 = totalRepo.findById(dto.getShippingId());
        Total shipping = byId3.get();
        yourOrder.setShipping(shipping);

        repo.save(yourOrder);
        return new Result("Your order information created and saved successfully", true);
    }

    public Result update(YourOrderDto dto, UUID id) {
        Optional<YourOrder> byId = repo.findById(id);
        if (byId.isPresent()) {
            YourOrder yourOrder = byId.get();
            Optional<Product> byProductId = productRepo.findById(dto.getProductId());
            Product product = byProductId.get();
            yourOrder.setProduct((List<Product>) product);

            Optional<Total> byId1 = totalRepo.findById(dto.getSubTotalId());
            Total subTotal = byId1.get();
            yourOrder.setSubTotal(subTotal);

            Optional<Total> byId2 = totalRepo.findById(dto.getTotalId());
            Total total = byId2.get();
            yourOrder.setTotal(total);

            Optional<Total> byId3 = totalRepo.findById(dto.getShippingId());
            Total shipping = byId3.get();
            yourOrder.setShipping(shipping);

            repo.save(yourOrder);
            return new Result("Your order information updated successfully", true);
        }
        return new Result("Your order information not found", false);
    }

    public Result delete(UUID id) {
        Optional<YourOrder> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Your order information deleted successfully", true);
        }
        return new Result("Your order information not found", false);
    }

}