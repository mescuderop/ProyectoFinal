package com.bank.passive.domain.services;

import com.bank.passive.domain.entities.PassiveAccountDto;
import com.bank.passive.domain.interfaces.IPassiveAccountService;
import com.bank.passive.domain.models.PersonModel;
import com.bank.passive.infraestructure.mapper.PassiveAccountMapper;
import com.bank.passive.infraestructure.repositories.PassiveAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.util.List;


@Service
public class PassiveAccountService implements IPassiveAccountService {


    PassiveAccountDto passiveAccountInfo;
    List<PassiveAccountDto> accountDtoList;
    String numberDocument;
    private static final Logger logger = LoggerFactory.getLogger(PassiveAccountService.class);

    @Autowired
    PassiveAccountRepository repository;

    public Mono<PersonModel> getPersonByNumberDocument(String numberDocument){
        Mono<PersonModel> personModelMono = WebClient.create()
                .get().uri("http://localhost:8001/api/person/getByNumberDocument/" + numberDocument)
                .retrieve().bodyToMono(PersonModel.class);

        personModelMono.subscribe();

        return personModelMono;
    }

   @Override
    public Flux<PassiveAccountDto> getAccountsByPerson(String numberDocument) {
       return repository.getAccountsByDocument(numberDocument);
   }



    @Override
    public Mono<PassiveAccountDto> createPassiveAccount(Mono<PassiveAccountDto> passiveAccountDto, String numberDocument){

        Mono<PersonModel> personModel = getPersonByNumberDocument(numberDocument);

        /*Mono<PassiveAccountDto> passiveAccountDtoMono = passiveAccountDto.map(p -> {
            Double comission = p.getCommission();
            comission = comission -1;
            p.setCommission(comission);
            return p;
        });*/
        //passiveAccountDtoMono.subscribe(e -> logger.info(e.getAccountNumber()));

        return repository.savePassiveAccount(passiveAccountDto);
    }

    @Override
    public Mono<PassiveAccountDto> updatePassiveAccount(Mono<PassiveAccountDto> passiveAccountDtoMono, String id){
        return repository.updatePassiveAccount(passiveAccountDtoMono, id);
    }

    @Override
    public Mono<Void> deletePassiveAccount(String id){
        return repository.deletePassiveAccount(id);
    }

}
