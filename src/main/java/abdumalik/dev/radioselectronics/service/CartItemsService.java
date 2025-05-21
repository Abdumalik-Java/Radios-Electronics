package abdumalik.dev.radioselectronics.service;

import abdumalik.dev.radioselectronics.dto.CartItemsDto;
import abdumalik.dev.radioselectronics.model.CartItems;
import abdumalik.dev.radioselectronics.model.Product;
import abdumalik.dev.radioselectronics.model.Result;
import abdumalik.dev.radioselectronics.model.Total;
import abdumalik.dev.radioselectronics.repository.CartItemsRepo;
import abdumalik.dev.radioselectronics.repository.ProductRepo;
import abdumalik.dev.radioselectronics.repository.TotalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CartItemsService {

    @Autowired
    CartItemsRepo repo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    TotalRepo totalRepo;

    public List<CartItems> findAll() {
        return repo.findAll();
    }

    public CartItems findById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(CartItemsDto dto) {
        CartItems cartItems = new CartItems();

        Optional<Total> byId = totalRepo.findById(dto.getSubTotal());
        Total total = byId.get();
        cartItems.setSubTotal(total);

        Optional<Product> byId1 = productRepo.findById(dto.getProductId());
        Product product = byId1.get();
        cartItems.setProductId((List<Product>) product);

        Optional<Product> byId2 = productRepo.findById(dto.getProductName());
        Product product2 = byId2.get();
        cartItems.setName(product2);

        Optional<Product> byId3 = productRepo.findById(dto.getProductPrice());
        Product product3 = byId3.get();
        cartItems.setPrice(product3);

        repo.save(cartItems);
        return new Result("Cart items created successfully", true);
    }

    public Result update(CartItemsDto dto, UUID id) {
        Optional<CartItems> byId = repo.findById(id);
        if (byId.isPresent()) {
            CartItems cartItems = byId.get();

            Optional<Total> byIdorg = totalRepo.findById(dto.getSubTotal());
            Total total = byIdorg.get();
            cartItems.setSubTotal(total);

            Optional<Product> byId1 = productRepo.findById(dto.getProductId());
            Product product = byId1.get();
            cartItems.setProductId((List<Product>) product);

            Optional<Product> byId2 = productRepo.findById(dto.getProductName());
            Product product2 = byId2.get();
            cartItems.setName(product2);

            Optional<Product> byId3 = productRepo.findById(dto.getProductPrice());
            Product product3 = byId3.get();
            cartItems.setPrice(product3);

            repo.save(cartItems);
            return new Result("Cart items updated successfully", true);
        }
        return new Result("Cart items not found", false);
    }

    public Result delete(UUID id) {
        Optional<CartItems> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Cart items deleted successfully", true);
        }
        return new Result("Cart items not found", false);
    }

}