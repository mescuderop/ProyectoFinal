package com.bank.passive.domain.services;

import com.bank.passive.domain.entities.MovementDto;
import com.bank.passive.domain.interfaces.IMovementService;
import com.bank.passive.infraestructure.mapper.MovementMapper;
import com.bank.passive.infraestructure.repositories.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovementService implements IMovementService {

    @Autowired
    private MovementRepository repository;

    @Override
    public Mono<MovementDto> saveMovement(Mono<MovementDto> movementDtoMono) {
        return repository.saveMovement(movementDtoMono);
    }

    @Override
    public Flux<MovementDto> getByPassiveId(String passiveId) {
        return repository.getByPassiveId(passiveId);
    }

    @Override
    public Flux<MovementDto> getByPassiveIdAndType(String passiveId, String operationType) {
        return repository.getByPassiveIdAndType(passiveId, operationType);
    }

}
