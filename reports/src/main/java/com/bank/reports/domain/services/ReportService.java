package com.bank.reports.domain.services;

import com.bank.reports.domain.entities.MovementPassiveDto;
import com.bank.reports.domain.interfaces.IReportService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class ReportService implements IReportService {

    public Flux<MovementPassiveDto> getPassiveMovementsByPassiveId(String passiveId){
        Flux<MovementPassiveDto> movementPassiveDtoFlux = WebClient.create()
                .get().uri("http://localhost:8002/api/movementPassive/getByPassiveId/" + passiveId)
                .retrieve().bodyToFlux(MovementPassiveDto.class);

        return movementPassiveDtoFlux;
    }

}
