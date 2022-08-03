package com.bank.passive.domain.services;

import com.bank.passive.domain.entities.CardPassiveDto;
import com.bank.passive.domain.interfaces.ICardPassiveService;
import com.bank.passive.infraestructure.repositories.CardPassiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CardPassiveService implements ICardPassiveService {

    @Autowired
    private CardPassiveRepository repository;

    @Override
    public Flux<CardPassiveDto> getAll(){
        return repository.getAll();
    }

    @Override
    public Mono<CardPassiveDto> getCardPassive(String id){
        return repository.getCardPassive(id);
    }

    @Override
    public Mono<CardPassiveDto> saveCardPassive(Mono<CardPassiveDto> cardpassiveDtoMono){
        return repository.saveCardPassive(cardpassiveDtoMono);
    }

    @Override
    public Mono<CardPassiveDto> updateCardPassive(Mono<CardPassiveDto> cardpassiveDtoMono, String id){
        return repository.updateCardPassive(cardpassiveDtoMono, id);
    }

    @Override
    public Mono<Void> deleteCardPassive(String id){
        return repository.deleteCardPassive(id);
    }

}
