package com.bank.passive.application.rest;

import com.bank.passive.domain.entities.MovementDto;
import com.bank.passive.domain.services.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/movementPassive")
public class MovementController {

    @Autowired
    private MovementService service;

    /***
     *
     * @param movementDtoMono
     * @return movementDtoMono
     */
    @PostMapping("/save")
    public Mono<MovementDto> save (@RequestBody Mono<MovementDto> movementDtoMono){
        return service.saveMovement(movementDtoMono);
    }

    /***
     *
     * @param passiveId
     * @return List of movements
     */
    @GetMapping("/getByPassiveId/{passiveId}")
    public Flux<MovementDto> getByPassiveId(@PathVariable String passiveId){
        return service.getByPassiveId(passiveId);
    }

    /***
     *
     * @param passiveId
     * @param operationType
     * @return List of movements
     */
    @GetMapping("/getByType/{passiveId}/{operationType}")
    public Flux<MovementDto> getByPassiveIdAndType(@PathVariable String passiveId, @PathVariable String operationType){
        return service.getByPassiveIdAndType(passiveId, operationType);
    }

}
