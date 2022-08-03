package com.bank.initial.application.rest;

import com.bank.initial.domain.entities.PersonDto;
import com.bank.initial.domain.entities.PersonTypeDto;
import com.bank.initial.domain.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService service;


    @GetMapping("/getAll")
    public Flux<PersonDto> getAll(){
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public Mono<PersonDto> getPerson(@PathVariable String id){
        Mono<PersonDto> personDtoMono=service.getPerson(id);
        System.out.println(personDtoMono.toString());
        return personDtoMono;
    }

    @GetMapping("/getByNumberDocument/{numberDocument}")
    public Mono<PersonDto> getPersonByDocument(@PathVariable String numberDocument){
        Mono<PersonDto> personDtoMono=service.getPersonByNumberDocument(numberDocument);
        System.out.println(personDtoMono.toString());
        return personDtoMono;
    }

    @PostMapping("/save")
    public Mono<PersonDto> savePerson(@RequestBody Mono<PersonDto> personDtoMono){
        return service.savePerson(personDtoMono);
    }

    @PutMapping("/update/{id}")
    public Mono<PersonDto> updatePerson(@RequestBody Mono<PersonDto> personDtoMono, @PathVariable String id){
        return service.updatePerson(personDtoMono,id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteOperation(@PathVariable String id){
        return service.deletePerson(id);
    }

}
