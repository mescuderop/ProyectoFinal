package com.bank.passive.domain.interfaces;

import com.bank.passive.domain.entities.PassiveAccountDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPassiveAccountService {
    public Mono<PassiveAccountDto> createPassiveAccount(Mono<PassiveAccountDto> passiveAccountDto, String numberDocument);
    public Flux<PassiveAccountDto> getAccountsByPerson(String numberDocument);
    public Mono<PassiveAccountDto> updatePassiveAccount(Mono<PassiveAccountDto> passiveAccountDtoMono, String id);
    public Mono<Void> deletePassiveAccount(String id);
}
