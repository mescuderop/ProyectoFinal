package com.bank.initial.application.rest;

import com.bank.initial.domain.entities.OperationTypeDto;
import com.bank.initial.domain.services.OperationTypeService;
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
@RequestMapping("/api/operationType")
public class OperationTypeController {

    @Autowired
    private OperationTypeService service;

    @GetMapping("/getAll")
    public Flux<OperationTypeDto> getAll(){
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public Mono<OperationTypeDto> getOperationType(@PathVariable String id){
        Mono<OperationTypeDto> operationTypeDtoMono=service.getOperationType(id);
        System.out.println(operationTypeDtoMono.toString());
        return operationTypeDtoMono;
    }

    @PostMapping("/save")
    public Mono<OperationTypeDto> saveOperationType(@RequestBody Mono<OperationTypeDto> operationTypeDtoMono){
        return service.saveOperationType(operationTypeDtoMono);
    }

    @PutMapping("/update/{id}")
    public Mono<OperationTypeDto> updateOperationType(@RequestBody Mono<OperationTypeDto> operationTypeDtoMono, @PathVariable String id){
        return service.updateOperationType(operationTypeDtoMono,id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteOperationType(@PathVariable String id){
        return service.deleteOperationType(id);
    }


}
