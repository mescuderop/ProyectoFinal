package com.bank.initial.infraestructure.mapper;

import com.bank.initial.domain.entities.OperationTypeDto;
import com.bank.initial.infraestructure.entities.OperationType;
import org.springframework.beans.BeanUtils;

public class OperationTypeMapper {
    public static OperationTypeDto entityToDto(OperationType operationType){
        OperationTypeDto operationTypeDto = new OperationTypeDto();
        BeanUtils.copyProperties(operationType, operationTypeDto);
        return operationTypeDto;
    }

    public static OperationType dtoToEntity(OperationTypeDto operationTypeDto){
        OperationType operationType = new OperationType();
        BeanUtils.copyProperties(operationTypeDto, operationType);
        return operationType;
    }
}
