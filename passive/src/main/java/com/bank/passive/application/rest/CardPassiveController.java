package com.bank.passive.application.rest;

import com.bank.passive.domain.entities.CardPassiveDto;
import com.bank.passive.domain.services.CardPassiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/cardPassive")
public class CardPassiveController {

    @Autowired
    private CardPassiveService service;

    @GetMapping("/getAll")
    public Flux<CardPassiveDto> getAll(){
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public Mono<CardPassiveDto> getCardPassive(@PathVariable String id){
        Mono<CardPassiveDto> cardPassiveDtoMono=service.getCardPassive(id);
        return cardPassiveDtoMono;
    }

    @PostMapping("/save")
    public Mono<CardPassiveDto> saveAccountType(@RequestBody Mono<CardPassiveDto> cardPassiveDtoMono){
        return service.saveCardPassive(cardPassiveDtoMono);
    }

    @PutMapping("/update/{id}")
    public Mono<CardPassiveDto> updateAccountType(@RequestBody Mono<CardPassiveDto> cardPassiveDtoMono, @PathVariable String id){
        return service.updateCardPassive(cardPassiveDtoMono,id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteAccountType(@PathVariable String id){
        return service.deleteCardPassive(id);
    }


}
