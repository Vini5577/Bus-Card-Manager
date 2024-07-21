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
    public ResponseEntity<String> addCard(@PathVariable Long userId, @RequestBody CardDto cardDto) {
        return cardService.addCardToUser(userId, cardDto);
    }

    @GetMapping("/{userId}/cards/get")
    public ResponseEntity<Object> listCards(@PathVariable Long userId) {
        return cardService.listCardsOfUser(userId);
    }

    @DeleteMapping("/{userId}/cards/delete/{cardId}")
    public ResponseEntity<String> deleteCard(@PathVariable Long userId, @PathVariable Long cardId) {
        return  cardService.deleteCard(userId, cardId);
    }

    @PutMapping("/{userId}/cards/status/{cardId}")
    public  ResponseEntity<String> changeCardStatus(@PathVariable Long userId, @PathVariable Long cardId) {
        return cardService.changeCardStatus(userId, cardId);
    }
}
