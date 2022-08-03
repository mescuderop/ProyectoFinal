package com.bank.initial.infraestructure.repositories;

import com.bank.initial.domain.entities.PersonDto;
import com.bank.initial.domain.entities.PersonTypeDto;
import com.bank.initial.infraestructure.crud.PersonCrudRepository;
import com.bank.initial.infraestructure.crud.PersonTypeCrudRepository;
import com.bank.initial.infraestructure.entities.Person;
import com.bank.initial.infraestructure.entities.PersonType;
import com.bank.initial.infraestructure.interfaces.IPersonRepository;
import com.bank.initial.infraestructure.mapper.PersonMapper;
import com.bank.initial.infraestructure.mapper.PersonTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class PersonRepository implements IPersonRepository {

    @Autowired
    private PersonCrudRepository crudRepository;

    @Override
    public Flux<PersonDto> getAll(){

        Flux<Person> personTypeFlux = crudRepository.findAll();

        return personTypeFlux.map(PersonMapper::entityToDto);
    }

    @Override
    public Mono<PersonDto> getPerson(String id){
        return crudRepository.findById(id).map(PersonMapper::entityToDto);
    }

    @Override
    public Mono<PersonDto> getPersonByNumberDocument(String numberDocument){
        return crudRepository.findByNumberDocument(numberDocument).map(PersonMapper::entityToDto);
    }

    @Override
    public Mono<PersonDto> savePerson(Mono<PersonDto> personDtoMono){
        return personDtoMono.map(PersonMapper::dtoToEntity)
                .flatMap(crudRepository::insert)
                .map(PersonMapper::entityToDto);
    }

    @Override
    public Mono<PersonDto> updatePerson(Mono<PersonDto> personDtoMono, String id){
        return crudRepository.findById(id)
                .flatMap(p-> personDtoMono.map(PersonMapper::dtoToEntity)
                        .doOnNext(e->e.setId(id))
                        .flatMap(crudRepository::save)
                        .map(PersonMapper::entityToDto));
    }

    @Override
    public Mono<Void> deletePerson(String id){
        return crudRepository.deleteById(id);
    }


}
