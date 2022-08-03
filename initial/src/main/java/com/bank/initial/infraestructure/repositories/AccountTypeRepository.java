package com.bank.initial.infraestructure.repositories;

import com.bank.initial.domain.entities.AccountTypeDto;
import com.bank.initial.infraestructure.crud.AccountTypeCrudRepository;
import com.bank.initial.infraestructure.interfaces.IAccountTypeRepository;
import com.bank.initial.infraestructure.mapper.AccountTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class AccountTypeRepository implements IAccountTypeRepository {
    @Autowired
    private AccountTypeCrudRepository crudRepository;

    public Flux<AccountTypeDto> getAll(){
        return crudRepository.findAll().map(AccountTypeMapper::entityToDto);
    }

    public Mono<AccountTypeDto> getAccountType(String id){
        return crudRepository.findById(id).map(AccountTypeMapper::entityToDto);
    }

    public Mono<AccountTypeDto> saveAccountType(Mono<AccountTypeDto> accountTypeDtoMono){
        return accountTypeDtoMono.map(AccountTypeMapper::dtoToEntity)
                .flatMap(crudRepository::insert)
                .map(AccountTypeMapper::entityToDto);
    }

    public Mono<AccountTypeDto> updateAccountType(Mono<AccountTypeDto> accountTypeDtoMono, String id){
        return crudRepository.findById(id)
                .flatMap(p-> accountTypeDtoMono.map(AccountTypeMapper::dtoToEntity)
                        .doOnNext(e->e.setId(id))
                        .flatMap(crudRepository::save)
                        .map(AccountTypeMapper::entityToDto));
    }

    public Mono<Void> deleteAccountType(String id){
        return crudRepository.deleteById(id);
    }
}
