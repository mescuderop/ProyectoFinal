package com.bank.passive.infraestructure.mapper;

import com.bank.passive.domain.entities.CardPassiveDto;
import com.bank.passive.infraestructure.entities.CardPassive;
import org.springframework.beans.BeanUtils;

public class CardPassiveMapper {
    public static CardPassiveDto entityToDto(CardPassive cardPassive){
        CardPassiveDto cardPassiveDto = new CardPassiveDto();
        BeanUtils.copyProperties(cardPassive, cardPassiveDto);
        return cardPassiveDto;
    }

    public static CardPassive dtoToEntity(CardPassiveDto cardPassiveDto){
        CardPassive cardPassive = new CardPassive();
        BeanUtils.copyProperties(cardPassiveDto, cardPassive);
        return cardPassive;
    }
}
