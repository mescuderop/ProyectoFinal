package com.bank.passive.infraestructure.entities;

import com.bank.passive.domain.models.AccountTypeModel;
import com.bank.passive.domain.models.PersonModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "passiveAccount")
public class PassiveAccount {

    @Id
    private String id;
    private String accountNumber;
    private String numberDocument;
    private String cardId;
    private String accountType;
    private Double commission;
    private Integer maxMovement;
    private String dateMovement;
    private Double lineAvailable;
}
