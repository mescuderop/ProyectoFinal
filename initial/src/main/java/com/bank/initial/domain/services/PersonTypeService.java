package com.bank.initial.domain.services;

import com.bank.initial.domain.entities.PersonTypeDto;
import com.bank.initial.domain.interfaces.IPersonTypeService;
import com.bank.initial.infraestructure.repositories.PersonTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonTypeService implements IPersonTypeService {

    @Autowired
    private PersonTypeRepository repository;

    @Override
    public Flux<PersonTypeDto> getAll(){
        return repository.getAll();
    }

    @Override
    public Mono<PersonTypeDto> getPersonType(String id){
        return repository.getPersonType(id);
    }

    @Override
    public Mono<PersonTypeDto> savePersonType(Mono<PersonTypeDto> personTypeDtoMono){
        return repository.savePersonType(personTypeDtoMono);
    }

    @Override
    public Mono<PersonTypeDto> updatePersonType(Mono<PersonTypeDto> personTypeDtoMono, String id){
        return repository.updatePersonType(personTypeDtoMono,id);
    }

    @Override
    public Mono<Void> deletePersonType(String id){
        return repository.deletePersonType(id);
    }

}
