package com.bank.initial.infraestructure.repositories;

import com.bank.initial.domain.entities.PersonTypeDto;
import com.bank.initial.infraestructure.crud.PersonTypeCrudRepository;
import com.bank.initial.infraestructure.entities.PersonType;
import com.bank.initial.infraestructure.interfaces.IPersonTypeRepository;
import com.bank.initial.infraestructure.mapper.PersonTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class PersonTypeRepository implements IPersonTypeRepository {

    @Autowired
    private PersonTypeCrudRepository crudRepository;

    @Override
    public Flux<PersonTypeDto> getAll(){

        Flux<PersonType> personTypeFlux = crudRepository.findAll();

        return personTypeFlux.map(PersonTypeMapper::entityToDto);
    }

    @Override
    public Mono<PersonTypeDto> getPersonType(String id){
        return crudRepository.findById(id).map(PersonTypeMapper::entityToDto);
    }

    @Override
    public Mono<PersonTypeDto> savePersonType(Mono<PersonTypeDto> personTypeDtoMono){
        return personTypeDtoMono.map(PersonTypeMapper::dtoToEntity)
                .flatMap(crudRepository::insert)
                .map(PersonTypeMapper::entityToDto);
    }

    @Override
    public Mono<PersonTypeDto> updatePersonType(Mono<PersonTypeDto> personTypeDtoMono, String id){
        return crudRepository.findById(id)
                .flatMap(p-> personTypeDtoMono.map(PersonTypeMapper::dtoToEntity)
                        .doOnNext(e->e.setId(id))
                        .flatMap(crudRepository::save)
                        .map(PersonTypeMapper::entityToDto));
    }

    @Override
    public Mono<Void> deletePersonType(String id){
        return crudRepository.deleteById(id);
    }

}
