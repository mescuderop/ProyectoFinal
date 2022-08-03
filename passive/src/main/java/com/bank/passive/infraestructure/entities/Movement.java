package com.bank.passive.infraestructure.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "movementPassive")
public class Movement {

    @Id
    private String movementId;
    private String passiveId;
    private String date;
    private String amount;
    private String operationType;

}
