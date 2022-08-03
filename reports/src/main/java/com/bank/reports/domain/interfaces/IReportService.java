package com.bank.reports.domain.interfaces;

import com.bank.reports.domain.entities.MovementPassiveDto;
import reactor.core.publisher.Flux;

public interface IReportService {
    public Flux<MovementPassiveDto> getPassiveMovementsByPassiveId(String passiveId);
}
