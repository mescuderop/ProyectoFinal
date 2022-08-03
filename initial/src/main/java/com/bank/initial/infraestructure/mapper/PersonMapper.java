package com.bank.initial.infraestructure.mapper;

import com.bank.initial.domain.entities.PersonDto;
import com.bank.initial.infraestructure.entities.Person;
import org.springframework.beans.BeanUtils;

public class PersonMapper {
    public static PersonDto entityToDto(Person person){
        PersonDto personDto = new PersonDto();
        BeanUtils.copyProperties(person, personDto);
        return personDto;
    }

    public static Person dtoToEntity(PersonDto personDto){
        Person person = new Person();
        BeanUtils.copyProperties(personDto, person);
        return person;
    }
}
