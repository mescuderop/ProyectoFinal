package com.bank.passive.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovementDto {
    private String movementId;
    private String passiveId;
    private String date;
    private String amount;
    private String operationType;
}
