package com.bank.passive.infraestructure.crud;

import com.bank.passive.infraestructure.entities.PassiveAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface PassiveAccountCrudRepository extends ReactiveMongoRepository<PassiveAccount, String> {
    Flux<PassiveAccount> findAllByNumberDocument(String numberDocument);
    Flux<PassiveAccount> findAllByNumberDocumentAndAccountType(String numberDocument, String accountType);

}
