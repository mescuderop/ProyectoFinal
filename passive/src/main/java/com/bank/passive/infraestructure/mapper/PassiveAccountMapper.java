package com.bank.passive.infraestructure.mapper;

import com.bank.passive.domain.entities.PassiveAccountDto;
import com.bank.passive.infraestructure.entities.CardPassive;
import com.bank.passive.infraestructure.entities.PassiveAccount;
import org.springframework.beans.BeanUtils;

public class PassiveAccountMapper {
    public static PassiveAccountDto entityToDto(PassiveAccount passiveAccount){
        PassiveAccountDto passiveAccountDto = new PassiveAccountDto();
        BeanUtils.copyProperties(passiveAccount, passiveAccountDto);
        return passiveAccountDto;
    }

    public static PassiveAccount dtoToEntity(PassiveAccountDto passiveAccountDto){
        PassiveAccount passiveAccount = new PassiveAccount();
        BeanUtils.copyProperties(passiveAccountDto, passiveAccount);
        return passiveAccount;
    }
}
