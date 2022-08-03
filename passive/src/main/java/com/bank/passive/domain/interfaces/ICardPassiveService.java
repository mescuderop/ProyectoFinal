package com.bank.passive.domain.interfaces;

import com.bank.passive.domain.entities.CardPassiveDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICardPassiveService {
    public Flux<CardPassiveDto> getAll();
    public Mono<CardPassiveDto> getCardPassive(String id);
    public Mono<CardPassiveDto> saveCardPassive(Mono<CardPassiveDto> cardpassiveDtoMono);
    public Mono<CardPassiveDto> updateCardPassive(Mono<CardPassiveDto> cardpassiveDtoMono, String id);
    public Mono<Void> deleteCardPassive(String id);
}
