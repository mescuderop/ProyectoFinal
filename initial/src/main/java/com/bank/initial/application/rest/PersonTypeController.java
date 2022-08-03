package com.bank.initial.application.rest;

import com.bank.initial.domain.entities.PersonTypeDto;
import com.bank.initial.domain.services.PersonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/personType")
public class PersonTypeController {

    @Autowired
    private PersonTypeService service;

    @GetMapping("/getAll")
    public Flux<PersonTypeDto> getAll(){
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public Mono<PersonTypeDto> getPersonType(@PathVariable String id){
        Mono<PersonTypeDto> personTypeDtoMono=service.getPersonType(id);
        System.out.println(personTypeDtoMono.toString());
        return personTypeDtoMono;
    }

    @PostMapping("/save")
    public Mono<PersonTypeDto> savePersonType(@RequestBody Mono<PersonTypeDto> personTypeDtoMono){
        return service.savePersonType(personTypeDtoMono);
    }

    @PutMapping("/update/{id}")
    public Mono<PersonTypeDto> updatePersonType(@RequestBody Mono<PersonTypeDto> personTypeDtoMono, @PathVariable String id){
        return service.updatePersonType(personTypeDtoMono,id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteOperationType(@PathVariable String id){
        return service.deletePersonType(id);
    }

}
