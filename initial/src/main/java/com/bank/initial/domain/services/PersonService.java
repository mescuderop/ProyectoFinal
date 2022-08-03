package com.bank.initial.domain.services;

import com.bank.initial.domain.entities.PersonDto;
import com.bank.initial.domain.interfaces.IPersonService;
import com.bank.initial.infraestructure.entities.Person;
import com.bank.initial.infraestructure.mapper.PersonMapper;
import com.bank.initial.infraestructure.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private PersonRepository repository;

    @Override
    public Flux<PersonDto> getAll(){
        return repository.getAll();
    }

    @Override
    public Mono<PersonDto> getPerson(String id){
        return repository.getPerson(id);
    }

    @Override
    public Mono<PersonDto> getPersonByNumberDocument(String numberDocument){
        return repository.getPersonByNumberDocument(numberDocument);
    }

    @Override
    public Mono<PersonDto> savePerson(Mono<PersonDto> personDtoMono){
        return repository.savePerson(personDtoMono);
    }

    @Override
    public Mono<PersonDto> updatePerson(Mono<PersonDto> personDtoMono, String id){
        return repository.updatePerson(personDtoMono, id);
    }

    @Override
    public Mono<Void> deletePerson(String id){
        return repository.deletePerson(id);
    }


}
