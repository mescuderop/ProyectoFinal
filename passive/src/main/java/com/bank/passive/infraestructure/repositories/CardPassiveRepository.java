package com.bank.passive.infraestructure.repositories;

import com.bank.passive.domain.entities.CardPassiveDto;
import com.bank.passive.infraestructure.crud.CardPassiveCrudRepository;
import com.bank.passive.infraestructure.entities.CardPassive;
import com.bank.passive.infraestructure.interfaces.ICardPassiveRepository;
import com.bank.passive.infraestructure.mapper.CardPassiveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CardPassiveRepository implements ICardPassiveRepository {

    @Autowired
    private CardPassiveCrudRepository crudRepository;

    @Override
    public Flux<CardPassiveDto> getAll(){
        Flux<CardPassive> cardPassiveFlux = crudRepository.findAll();
        return cardPassiveFlux.map(CardPassiveMapper::entityToDto);
    }

    @Override
    public Mono<CardPassiveDto> getCardPassive(String id){
        return crudRepository.findById(id).map(CardPassiveMapper::entityToDto);
    }

    @Override
    public Mono<CardPassiveDto> saveCardPassive(Mono<CardPassiveDto> cardPassiveDtoMono){
        return cardPassiveDtoMono.map(CardPassiveMapper::dtoToEntity)
                .flatMap(crudRepository::insert)
                .map(CardPassiveMapper::entityToDto);
    }

    @Override
    public Mono<CardPassiveDto> updateCardPassive(Mono<CardPassiveDto> cardPassiveDtoMono, String id){
        return crudRepository.findById(id)
                .flatMap(p-> cardPassiveDtoMono.map(CardPassiveMapper::dtoToEntity)
                        .doOnNext(e->e.setCardPassiveId(id))
                        .flatMap(crudRepository::save)
                        .map(CardPassiveMapper::entityToDto));
    }

    @Override
    public Mono<Void> deleteCardPassive(String id){
        return crudRepository.deleteById(id);
    }

}
