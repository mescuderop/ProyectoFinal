package com.bank.passive.infraestructure.interfaces;

import com.bank.passive.domain.entities.PassiveAccountDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPassiveAccountRepository {
    public Mono<PassiveAccountDto> savePassiveAccount(Mono<PassiveAccountDto> passiveAccountDtoMono);
    public Flux<PassiveAccountDto> getAccountsByDocument(String numberDocument);
    public Flux<PassiveAccountDto> getAccountsByDocumentAndType(String numberDocument, String accountType);
    public Mono<PassiveAccountDto> updatePassiveAccount(Mono<PassiveAccountDto> passiveAccountDtoMono, String id);
    public Mono<Void> deletePassiveAccount(String id);

}
