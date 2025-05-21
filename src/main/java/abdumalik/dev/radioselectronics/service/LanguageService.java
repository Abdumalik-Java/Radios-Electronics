package abdumalik.dev.radioselectronics.service;

import abdumalik.dev.radioselectronics.dto.LanguageDto;
import abdumalik.dev.radioselectronics.model.Language;
import abdumalik.dev.radioselectronics.model.Result;
import abdumalik.dev.radioselectronics.repository.LanguageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LanguageService {

    @Autowired
    LanguageRepo repo;

    public List<Language> findAll() {
        return repo.findAll();
    }

    public Language findById(UUID id) {
        return repo.findById(id).get();
    }

    public Language findByName(String name) {
        return repo.findByName(name).get();
    }

    public Result create(LanguageDto dto) {
        Language language = new Language();
        language.setName(dto.getName());
        language.setUz(dto.getUz());
        language.setRu(dto.getRu());
        language.setEng(dto.getEng());
        repo.save(language);
        return new Result("Language successfully created", true);
    }

    public Result update(LanguageDto dto, UUID id) {
        Optional<Language> byId = repo.findById(id);
        if (byId.isPresent()) {
            Language language = byId.get();
            language.setName(dto.getName());
            language.setUz(dto.getUz());
            language.setRu(dto.getRu());
            language.setEng(dto.getEng());
            repo.save(language);
            return new Result("Language successfully updated", true);
        }
        return new Result("Language not found", false);
    }

    public Result delete(UUID id) {
        Optional<Language> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Language successfully deleted", true);
        }
        return new Result("Language not found", false);
    }

}