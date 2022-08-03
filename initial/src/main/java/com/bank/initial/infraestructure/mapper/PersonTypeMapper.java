package com.bank.initial.infraestructure.mapper;

import com.bank.initial.domain.entities.PersonTypeDto;
import com.bank.initial.infraestructure.entities.PersonType;
import org.springframework.beans.BeanUtils;

public class PersonTypeMapper {
    public static PersonTypeDto entityToDto(PersonType personType){
        PersonTypeDto personTypeDto = new PersonTypeDto();
        BeanUtils.copyProperties(personType, personTypeDto);
        return personTypeDto;
    }

    public static PersonType dtoToEntity(PersonTypeDto personTypeDto){
        PersonType personType = new PersonType();
        BeanUtils.copyProperties(personTypeDto, personType);
        return personType;
    }
}
