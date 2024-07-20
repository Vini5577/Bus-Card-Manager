package com.api.busCardManager.repositories;

import com.api.busCardManager.model.Card;
import com.api.busCardManager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {

    Optional<Card> findByNumber (String number);
}
