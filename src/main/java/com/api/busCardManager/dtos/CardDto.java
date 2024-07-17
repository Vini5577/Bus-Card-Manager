package com.api.busCardManager.dtos;

import com.api.busCardManager.model.CardType;
import com.api.busCardManager.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

public class CardDto {

    @NotBlank
    private String number;

    private boolean status;

    @NotBlank
    private CardType type;

    private User user;
}
