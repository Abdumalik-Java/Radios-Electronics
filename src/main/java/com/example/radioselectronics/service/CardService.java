package com.example.radioselectronics.service;

import com.example.radioselectronics.dto.CardDto;
import com.example.radioselectronics.model.Card;
import com.example.radioselectronics.model.Result;
import com.example.radioselectronics.repository.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CardService {

    @Autowired
    CardRepo cardRepo;

    public List<Card> findAll() {
        return cardRepo.findAll();
    }

    public Card findById(UUID id) {
        return cardRepo.findById(id).get();
    }

    public Result create(CardDto cardDto) {
        Card card = new Card();
        card.setCardNumber(cardDto.getCardNumber());
        card.setExpiryDate(cardDto.getExpiryDate());
        card.setCvvNumber(cardDto.getCvvNumber());
        cardRepo.save(card);
        return new Result("Card information created and saved successfully", true);
    }

    public Result update(CardDto cardDto, UUID id) {
        Optional<Card> byId = cardRepo.findById(id);
        if (byId.isPresent()) {
            Card card = byId.get();
            card.setCardNumber(cardDto.getCardNumber());
            card.setExpiryDate(cardDto.getExpiryDate());
            card.setCvvNumber(cardDto.getCvvNumber());
            cardRepo.save(card);
            return new Result("Card information updated successfully", true);
        }
        return new Result("Card information not found", false);
    }

    public Result delete(UUID id) {
        Optional<Card> byId = cardRepo.findById(id);
        if (byId.isPresent()) {
            cardRepo.delete(byId.get());
            return new Result("Card information deleted successfully", true);
        }
        return new Result("Card information not found", false);
    }

}