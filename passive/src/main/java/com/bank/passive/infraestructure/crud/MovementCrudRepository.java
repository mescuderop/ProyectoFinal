package com.bank.passive.infraestructure.crud;

import com.bank.passive.infraestructure.entities.Movement;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface MovementCrudRepository extends ReactiveMongoRepository<Movement, String> {

    Flux<Movement> findByPassiveId(String passiveId);
    Flux<Movement> findByPassiveIdAndOperationType(String passiveId, String operationType);

}
