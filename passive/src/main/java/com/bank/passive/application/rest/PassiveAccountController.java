package com.bank.passive.application.rest;

import com.bank.passive.domain.entities.PassiveAccountDto;
import com.bank.passive.domain.models.PersonModel;
import com.bank.passive.domain.services.PassiveAccountService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/passive")
public class PassiveAccountController {

    @Autowired
    private PassiveAccountService service;

    /***
     * Ask for main information of client
     * @param numberDocument identity client
     * @return information of client
     */


    @CircuitBreaker(name = "passiveCB", fallbackMethod = "fallBackGetPerson")
    @GetMapping("/getPerson/{numberDocument}")
    public Mono<PersonModel> getPersonByDocument(@PathVariable String numberDocument){
        return  service.getPersonByNumberDocument(numberDocument);
    }

    @PostMapping("/create/{numberDocument}")
    public Mono<PassiveAccountDto> createPassiveAccount(
            @RequestBody Mono<PassiveAccountDto> passiveAccountDtoMono,
            @PathVariable String numberDocument){
        return service.createPassiveAccount(passiveAccountDtoMono, numberDocument);
    }

    @GetMapping("/getAccounts/{numberDocument}")
    public Flux<PassiveAccountDto> getAccountsByDocument(@PathVariable String numberDocument){
        return  service.getAccountsByPerson(numberDocument);
    }

    /*@GetMapping("/getAccounts/{numberDocument}/{accountType}")
    public Flux<PassiveAccountDto> getAccountsByDocument(@PathVariable String numberDocument, @PathVariable String accountType){
        return  service.getAccountsByPerson(numberDocument, accountType);
    }*/

    private Mono<PersonModel> fallBackGetPerson(Throwable ex){
        System.out.println("---> " + ex.getMessage());
        PersonModel personModel= new PersonModel();
        personModel.setName("Servicio de informacion de Persona fuera de servicio");
        return Mono.just(personModel);
    }

}
