package com.bank.passive.domain.interfaces;

import com.bank.passive.domain.entities.MovementDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMovementService {
    public Mono<MovementDto> saveMovement(Mono<MovementDto> movementDtoMono);
    public Flux<MovementDto> getByPassiveId(String passiveId);
    public Flux<MovementDto> getByPassiveIdAndType(String passiveId, String operationType);
}
