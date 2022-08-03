package com.bank.reports.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovementPassiveDto {
    private String movementId;
    private String passiveId;
    private String date;
    private String amount;
    private String operationType;
}
