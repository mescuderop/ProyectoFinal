package com.bank.passive.infraestructure.repositories;

import com.bank.passive.domain.entities.PassiveAccountDto;
import com.bank.passive.infraestructure.crud.PassiveAccountCrudRepository;
import com.bank.passive.infraestructure.interfaces.IPassiveAccountRepository;
import com.bank.passive.infraestructure.mapper.PassiveAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class PassiveAccountRepository implements IPassiveAccountRepository {

    @Autowired
    private PassiveAccountCrudRepository crudRepository;

    @Override
    public Mono<PassiveAccountDto> savePassiveAccount(Mono<PassiveAccountDto> passiveAccountDtoMono){
        return passiveAccountDtoMono.map(PassiveAccountMapper::dtoToEntity)
                .flatMap(crudRepository::insert)
                .map(PassiveAccountMapper::entityToDto);
    }

    @Override
    public Flux<PassiveAccountDto> getAccountsByDocument(String numberDocument){
        return crudRepository.findAllByNumberDocument(numberDocument).map(PassiveAccountMapper::entityToDto);

    }

    @Override
    public Flux<PassiveAccountDto> getAccountsByDocumentAndType(String numberDocument, String accountType){
        return crudRepository.findAllByNumberDocumentAndAccountType(numberDocument, accountType).map(PassiveAccountMapper::entityToDto);

    }

    @Override
    public Mono<PassiveAccountDto> updatePassiveAccount(Mono<PassiveAccountDto> passiveAccountDtoMono, String id){
        return crudRepository.findById(id)
                .flatMap(p-> passiveAccountDtoMono.map(PassiveAccountMapper::dtoToEntity)
                        .doOnNext(e->e.setId(id))
                        .flatMap(crudRepository::save)
                        .map(PassiveAccountMapper::entityToDto));
    }

    @Override
    public Mono<Void> deletePassiveAccount(String id){
        return crudRepository.deleteById(id);
    }

}
