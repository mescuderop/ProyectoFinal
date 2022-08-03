package com.bank.initial.infraestructure.crud;

import com.bank.initial.infraestructure.entities.PersonType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PersonTypeCrudRepository extends ReactiveMongoRepository<PersonType, String> {
}
