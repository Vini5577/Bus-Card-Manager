package com.api.busCardManager.service;

import com.api.busCardManager.dtos.CardDto;
import com.api.busCardManager.model.Card;
import com.api.busCardManager.model.User;
import com.api.busCardManager.repositories.CardRepository;
import com.api.busCardManager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CardRepository cardRepository;

    public ResponseEntity<String> addCardToUser(Long userId, CardDto cardDto) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(!userOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }

        User user = userOptional.get();

        Card card = new Card();
        card.setUser(user);
        card.setNumber(cardDto.getNumber());
        card.setType(cardDto.getType());
        card.setStatus(false);
        cardRepository.save(card);
        return ResponseEntity.status(HttpStatus.OK).body("Cartão adicionado com sucesso!");
    }

    public ResponseEntity<Object> listCardsOfUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if(!userOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(userOptional.get().getCards());
    }

    public ResponseEntity<String> deleteCard(Long userId, Long cardId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Card> cardOptional = cardRepository.findById(cardId);

        if(!userOptional.isPresent() && !cardOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário ou card não existe!");
        }

        Card card = cardOptional.get();
        if(card.getUser().getId().equals(userId)) {
            cardRepository.delete(card);
            return  ResponseEntity.status(HttpStatus.OK).body("Cartão removido com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cartão não é utilizado pelo usuário");
        }
    }

    public ResponseEntity<String> changeCardStatus(Long userId, Long cardId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Card> cardOptional = cardRepository.findById(cardId);

        if(!userOptional.isPresent() && !cardOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário ou card não existe!");
        }

        Card card = cardOptional.get();

        if(card.getUser().getId().equals(userId)) {
            card.setStatus(!card.isStatus());
            cardRepository.save(card);
            return ResponseEntity.status(HttpStatus.OK).body("Status do cartão atualizado!");
        } else {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cartão não é utilizado pelo usuário");
        }


    }
}
