package com.api.busCardManager.dtos;

import com.api.busCardManager.model.Card;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    private List<Card> cards;
}
