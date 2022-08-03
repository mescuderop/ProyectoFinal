package com.bank.passive.infraestructure.repositories;

import com.bank.passive.domain.entities.MovementDto;
import com.bank.passive.infraestructure.crud.MovementCrudRepository;
import com.bank.passive.infraestructure.interfaces.IMovementRepository;
import com.bank.passive.infraestructure.mapper.MovementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class MovementRepository implements IMovementRepository {

    @Autowired
    private MovementCrudRepository crudRepository;

    @Override
    public Mono<MovementDto> saveMovement(Mono<MovementDto> movementDtoMono) {
        return movementDtoMono.map(MovementMapper::dtoToEntity)
                .flatMap(crudRepository::insert)
                .map(MovementMapper::entityToDto);
    }

    @Override
    public Flux<MovementDto> getByPassiveId(String passiveId){
        return crudRepository.findByPassiveId(passiveId).map(MovementMapper::entityToDto);
    }

    @Override
    public Flux<MovementDto> getByPassiveIdAndType(String passiveId, String operationType){
        return crudRepository.findByPassiveIdAndOperationType(passiveId, operationType).map(MovementMapper::entityToDto);
    }
}
