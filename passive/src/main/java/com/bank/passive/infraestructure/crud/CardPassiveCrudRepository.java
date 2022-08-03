package com.bank.passive.infraestructure.crud;

import com.bank.passive.infraestructure.entities.CardPassive;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CardPassiveCrudRepository extends ReactiveMongoRepository<CardPassive, String> {
}
