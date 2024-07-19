package com.api.busCardManager.dtos;

import com.api.busCardManager.model.CardType;
import com.api.busCardManager.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CardDto {

    @NotBlank
    private String number;

    private boolean status;

    @NotBlank
    private CardType type;
}
