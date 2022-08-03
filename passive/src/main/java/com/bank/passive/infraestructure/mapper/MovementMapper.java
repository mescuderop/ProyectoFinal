package com.bank.passive.infraestructure.mapper;

import com.bank.passive.domain.entities.CardPassiveDto;
import com.bank.passive.domain.entities.MovementDto;
import com.bank.passive.infraestructure.entities.CardPassive;
import com.bank.passive.infraestructure.entities.Movement;
import org.springframework.beans.BeanUtils;

public class MovementMapper {

    public static MovementDto entityToDto(Movement movement){
        MovementDto movementDto = new MovementDto();
        BeanUtils.copyProperties(movement, movementDto);
        return movementDto;
    }

    public static Movement dtoToEntity(MovementDto movementDto){
        Movement movement = new Movement();
        BeanUtils.copyProperties(movementDto, movement);
        return movement;
    }

}
