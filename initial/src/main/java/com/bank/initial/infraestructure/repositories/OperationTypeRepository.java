package com.bank.initial.infraestructure.repositories;

import com.bank.initial.domain.entities.OperationTypeDto;
import com.bank.initial.infraestructure.crud.OperationTypeCrudRepository;
import com.bank.initial.infraestructure.interfaces.IOperationTypeRepository;
import com.bank.initial.infraestructure.mapper.OperationTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class OperationTypeRepository implements IOperationTypeRepository {
    @Autowired
    private OperationTypeCrudRepository crudRepository;

    @Override
    public Flux<OperationTypeDto> getAll(){
        return crudRepository.findAll().map(OperationTypeMapper::entityToDto);
    }

    @Override
    public Mono<OperationTypeDto> getOperationType(String id){
        return crudRepository.findById(id).map(OperationTypeMapper::entityToDto);
    }

    @Override
    public Mono<OperationTypeDto> saveOperationType(Mono<OperationTypeDto> operationTypeDtoMono){
        return operationTypeDtoMono.map(OperationTypeMapper::dtoToEntity)
                .flatMap(crudRepository::insert)
                .map(OperationTypeMapper::entityToDto);
    }

    @Override
    public Mono<OperationTypeDto> updateOperationType(Mono<OperationTypeDto> operationTypeDtoMono, String id){
        return crudRepository.findById(id)
                .flatMap(p-> operationTypeDtoMono.map(OperationTypeMapper::dtoToEntity)
                        .doOnNext(e->e.setId(id))
                        .flatMap(crudRepository::save)
                        .map(OperationTypeMapper::entityToDto));
    }

    @Override
    public Mono<Void> deleteOperationType(String id){
        return crudRepository.deleteById(id);
    }

}
