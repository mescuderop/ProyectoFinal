package com.bank.initial.infraestructure.interfaces;

import com.bank.initial.domain.entities.PersonDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonRepository {

    public Flux<PersonDto> getAll();
    public Mono<PersonDto> getPerson(String id);
    public Mono<PersonDto> getPersonByNumberDocument(String numberDocument);
    public Mono<PersonDto> savePerson(Mono<PersonDto> personDtoMono);
    public Mono<PersonDto> updatePerson(Mono<PersonDto> personDtoMono, String id);
    public Mono<Void> deletePerson(String id);
}
