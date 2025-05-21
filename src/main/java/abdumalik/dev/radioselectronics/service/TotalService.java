package abdumalik.dev.radioselectronics.service;

import abdumalik.dev.radioselectronics.dto.TotalDto;
import abdumalik.dev.radioselectronics.model.Result;
import abdumalik.dev.radioselectronics.model.Total;
import abdumalik.dev.radioselectronics.repository.TotalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TotalService {

    @Autowired
    TotalRepo repo;

    public List<Total> getAll() {
        return repo.findAll();
    }

    public Total getById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(TotalDto dto) {
        Total total = new Total();
        total.setSubTotalPrice(dto.getSubTotalPrice());
        total.setTotalPrice(dto.getTotalPrice());
        total.setShippingCost(dto.getShippingCost());
        repo.save(total);
        return new Result("Total cost information created successfully", true);
    }

    public Result update(TotalDto dto, UUID id) {
        Optional<Total> byId = repo.findById(id);
        if (byId.isPresent()) {
            Total total = byId.get();
            total.setSubTotalPrice(dto.getSubTotalPrice());
            total.setTotalPrice(dto.getTotalPrice());
            total.setShippingCost(dto.getShippingCost());
            repo.save(total);
            return new Result("Total cost information updated successfully", true);
        }
        return new Result("Total cost information not found", false);
    }

    public Result delete(UUID id) {
        Optional<Total> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.deleteById(id);
            return new Result("Total cost information deleted successfully", true);
        }
        return new Result("Total cost information not found", false);
    }

}