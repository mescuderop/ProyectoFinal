package com.bank.reports.application;

import com.bank.reports.domain.entities.MovementPassiveDto;
import com.bank.reports.domain.entities.PassiveAccountDto;
import com.bank.reports.domain.services.ReportService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/reportPassive")
public class ReportPassiveController {

    @Autowired
    private ReportService service;

    /***
     *
     * @param passiveId
     * @return List of movements
     */

    @CircuitBreaker(name = "reportsCB", fallbackMethod = "fallback")
    @GetMapping("/getMovementsPassive/{passiveId}")
    public Flux<MovementPassiveDto> getMovementsByPassiveId(@PathVariable String passiveId){
        return service.getPassiveMovementsByPassiveId(passiveId);
    }

    public Flux<MovementPassiveDto> fallback(Throwable ex){

        MovementPassiveDto passiveDto = new MovementPassiveDto();
        passiveDto.setAmount("Servicio de consulta de movimiento ");
        Flux<MovementPassiveDto> passiveDtoFlux = Flux.just(passiveDto);


        return passiveDtoFlux;
    }

}
