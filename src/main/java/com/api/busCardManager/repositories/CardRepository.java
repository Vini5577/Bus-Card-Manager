package com.api.busCardManager.repositories;

import com.api.busCardManager.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
