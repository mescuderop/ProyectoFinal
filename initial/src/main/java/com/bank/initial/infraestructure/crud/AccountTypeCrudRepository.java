package com.bank.initial.infraestructure.crud;

import com.bank.initial.infraestructure.entities.AccountType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AccountTypeCrudRepository extends ReactiveMongoRepository<AccountType, String> {
}
