package com.bank.passive.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardPassiveDto {
    private String cardPassiveId;
    private String cardNumber;
    private String dateExpire;
    private String nameCard;
}
