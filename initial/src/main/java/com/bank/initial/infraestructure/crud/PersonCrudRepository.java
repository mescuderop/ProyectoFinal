package com.bank.initial.infraestructure.crud;

import com.bank.initial.infraestructure.entities.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface PersonCrudRepository extends ReactiveMongoRepository<Person, String> {
    Mono<Person> findByNumberDocument(String numberDocument);
}
