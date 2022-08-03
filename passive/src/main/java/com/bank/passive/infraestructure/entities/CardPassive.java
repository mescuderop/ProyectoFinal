package com.bank.passive.infraestructure.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cardPassive")
public class CardPassive {
    @Id
    private String cardPassiveId;
    private String cardNumber;
    private String dateExpire;
    private String nameCard;
}
