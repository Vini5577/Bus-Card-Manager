package com.api.busCardManager.controller;

import com.api.busCardManager.dtos.CardDto;
import com.api.busCardManager.service.CardService;
import com.api.busCardManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("/{userId}/cards/add")
    public ResponseEntity<Object> addCard(@PathVariable Long userId, @RequestBody CardDto cardDto) {
        cardService.addCardToUser(userId, cardDto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}/cards/get")
    public ResponseEntity<Object> listCards(@PathVariable Long userId) {
        return cardService.listCardsOfUser(userId);
    }

    @GetMapping("/{userId}/cards/get/{cardId}")
    public ResponseEntity<Object> oneCard(@PathVariable Long userId, @PathVariable Long cardId) {
        return cardService.oneCardOfUser(userId, cardId);
    }

    @DeleteMapping("/{userId}/cards/delete/{cardId}")
    public ResponseEntity<String> deleteCard(@PathVariable Long userId, @PathVariable Long cardId) {
        cardService.deleteCard(userId, cardId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userId}/cards/status/{cardId}")
    public  ResponseEntity<Object> changeCardStatus(@PathVariable Long userId, @PathVariable Long cardId) {
        cardService.changeCardStatus(userId, cardId);
        return ResponseEntity.noContent().build();
    }
}
