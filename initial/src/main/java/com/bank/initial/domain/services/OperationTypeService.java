package com.bank.initial.domain.services;

import com.bank.initial.domain.entities.OperationTypeDto;
import com.bank.initial.infraestructure.repositories.OperationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OperationTypeService {
    @Autowired
    OperationTypeRepository repository;

    public Flux<OperationTypeDto> getAll(){
        return repository.getAll();
    }

    public Mono<OperationTypeDto> getOperationType(String id){
        return repository.getOperationType(id);
    }

    public Mono<OperationTypeDto> saveOperationType(Mono<OperationTypeDto> operationTypeDtoMono){
        return repository.saveOperationType(operationTypeDtoMono);
    }

    public Mono<OperationTypeDto> updateOperationType(Mono<OperationTypeDto> operationTypeDtoMono, String id){
        return repository.updateOperationType(operationTypeDtoMono,id);
    }

    public Mono<Void> deleteOperationType(String id){
        return repository.deleteOperationType(id);
    }
}
