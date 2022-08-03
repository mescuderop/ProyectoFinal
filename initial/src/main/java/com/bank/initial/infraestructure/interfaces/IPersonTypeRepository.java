package com.bank.initial.infraestructure.interfaces;

import com.bank.initial.domain.entities.PersonTypeDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonTypeRepository {

    public Flux<PersonTypeDto> getAll();
    public Mono<PersonTypeDto> getPersonType(String id);
    public Mono<PersonTypeDto> savePersonType(Mono<PersonTypeDto> personTypeDtoMono);
    public Mono<PersonTypeDto> updatePersonType(Mono<PersonTypeDto> personTypeDtoMono, String id);
    public Mono<Void> deletePersonType(String id);

}
