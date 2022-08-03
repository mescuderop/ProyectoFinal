package com.bank.passive.domain.entities;

import com.bank.passive.domain.models.AccountTypeModel;
import com.bank.passive.domain.models.PersonModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassiveAccountDto {
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
