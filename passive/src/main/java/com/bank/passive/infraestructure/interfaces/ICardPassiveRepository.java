package com.bank.passive.infraestructure.interfaces;

import com.bank.passive.domain.entities.CardPassiveDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICardPassiveRepository {

    public Flux<CardPassiveDto> getAll();
    public Mono<CardPassiveDto> getCardPassive(String id);
    public Mono<CardPassiveDto> saveCardPassive(Mono<CardPassiveDto> cardPassiveDtoMono);
    public Mono<CardPassiveDto> updateCardPassive(Mono<CardPassiveDto> cardPassiveDtoMono, String id);
    public Mono<Void> deleteCardPassive(String id);
}
