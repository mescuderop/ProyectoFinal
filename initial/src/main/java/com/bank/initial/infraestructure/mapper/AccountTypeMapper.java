package com.bank.initial.infraestructure.mapper;

import com.bank.initial.domain.entities.AccountTypeDto;
import com.bank.initial.infraestructure.entities.AccountType;
import org.springframework.beans.BeanUtils;

public class AccountTypeMapper {
    public static AccountTypeDto entityToDto(AccountType accountType){
        AccountTypeDto accountTypeDto = new AccountTypeDto();
        BeanUtils.copyProperties(accountType, accountTypeDto);
        return accountTypeDto;
    }

    public static AccountType dtoToEntity(AccountTypeDto accountTypeDto){
        AccountType accountType = new AccountType();
        BeanUtils.copyProperties(accountTypeDto, accountType);
        return accountType;
    }

}
