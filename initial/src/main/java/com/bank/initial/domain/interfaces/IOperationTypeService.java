package com.bank.initial.domain.interfaces;

import com.bank.initial.domain.entities.OperationTypeDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IOperationTypeService {
    public Flux<OperationTypeDto> getAll();
    public Mono<OperationTypeDto> getOperationType(String id);
    public Mono<OperationTypeDto> saveOperationType(Mono<OperationTypeDto> operationTypeDtoMono);
    public Mono<OperationTypeDto> updateOperationType(Mono<OperationTypeDto> operationTypeDtoMono, String id);
    public Mono<Void> deleteOperationType(String id);
}
