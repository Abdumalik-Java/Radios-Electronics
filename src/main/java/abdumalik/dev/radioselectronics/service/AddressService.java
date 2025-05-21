package abdumalik.dev.radioselectronics.service;

import abdumalik.dev.radioselectronics.dto.AddressDto;
import abdumalik.dev.radioselectronics.model.Address;
import abdumalik.dev.radioselectronics.model.Result;
import abdumalik.dev.radioselectronics.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService {

    @Autowired
    AddressRepo repo;

    public List<Address> getAllAddresses() {
        return repo.findAll();
    }

    public Address getAddressById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(AddressDto dto) {
        Address address = new Address();
        address.setCountry(dto.getCountry());
        address.setCity(dto.getCity());
        address.setStreet(dto.getStreet());
        address.setZipCode(dto.getZipCode());
        repo.save(address);
        return new Result("Address information created successfully", true);
    }

    public Result update(AddressDto dto, UUID id) {
        Optional<Address> byId = repo.findById(id);
        if (byId.isPresent()) {
            Address address = byId.get();
            address.setCountry(dto.getCountry());
            address.setCity(dto.getCity());
            address.setStreet(dto.getStreet());
            address.setZipCode(dto.getZipCode());
            repo.save(address);
            return new Result("Address information updated successfully", true);
        }
        return new Result("Address information not found", false);
    }

    public Result delete(UUID id) {
        Optional<Address> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.deleteById(id);
            return new Result("Address information deleted successfully", true);
        }
        return new Result("Address information not found", false);
    }

}