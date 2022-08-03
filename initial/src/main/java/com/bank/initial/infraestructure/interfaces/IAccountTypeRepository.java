package com.bank.initial.infraestructure.interfaces;

import com.bank.initial.domain.entities.AccountTypeDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAccountTypeRepository {
    public Flux<AccountTypeDto> getAll();
    public Mono<AccountTypeDto> getAccountType(String id);
    public Mono<AccountTypeDto> saveAccountType(Mono<AccountTypeDto> accountTypeDtoMono);
    public Mono<AccountTypeDto> updateAccountType(Mono<AccountTypeDto> accountTypeDtoMono, String id);
    public Mono<Void> deleteAccountType(String id);
}
