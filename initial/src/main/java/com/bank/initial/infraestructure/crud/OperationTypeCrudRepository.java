package com.bank.initial.infraestructure.crud;

import com.bank.initial.infraestructure.entities.OperationType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface OperationTypeCrudRepository extends ReactiveMongoRepository<OperationType, String> {
}
