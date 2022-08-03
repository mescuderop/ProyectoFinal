package com.bank.initial.domain.services;

import com.bank.initial.domain.entities.AccountTypeDto;
import com.bank.initial.domain.interfaces.IAccountTypeService;
import com.bank.initial.infraestructure.repositories.AccountTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountTypeService implements IAccountTypeService {
    @Autowired
    private AccountTypeRepository repository;

    @Override
    public Flux<AccountTypeDto> getAll(){ return repository.getAll(); }

    @Override
    public Mono<AccountTypeDto> getAccountType(String id){ return repository.getAccountType(id); }

    @Override
    public Mono<AccountTypeDto> saveAccountType(Mono<AccountTypeDto> accountTypeDtoMono){return repository.saveAccountType(accountTypeDtoMono); }

    @Override
    public Mono<AccountTypeDto> updateAccountType(Mono<AccountTypeDto> accountTypeDtoMono, String id){return repository.updateAccountType(accountTypeDtoMono,id); }

    @Override
    public Mono<Void> deleteAccountType(String id){ return repository.deleteAccountType(id); }
}
