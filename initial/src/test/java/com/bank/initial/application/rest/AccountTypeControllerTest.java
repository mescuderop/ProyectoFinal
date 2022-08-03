package com.bank.initial.application.rest;

import com.bank.initial.domain.entities.AccountTypeDto;
import com.bank.initial.domain.services.AccountTypeService;
import com.bank.initial.infraestructure.repositories.AccountTypeRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.blockhound.BlockHound;
import reactor.blockhound.BlockingOperationError;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/***
 * using stepverifier
 */

@ExtendWith(SpringExtension.class)
class AccountTypeControllerTest {

    @InjectMocks
    private AccountTypeService service;

    @Mock
    private AccountTypeRepository repository;

    private AccountTypeDto accountTypeDto;


    @BeforeAll
    public static void blockHoundSetup(){
        BlockHound.install();
    }

    @Test
    public void blockHoundWorks() {
        try {
            FutureTask<?> task = new FutureTask<>(() -> {
                Thread.sleep(0);
                return "";
            });
            Schedulers.parallel().schedule(task);

            task.get(5, TimeUnit.SECONDS);
            Assertions.fail("should fail");
        } catch (Exception e) {
            Assertions.assertTrue(e.getCause() instanceof BlockingOperationError);
        }
    }

    @BeforeEach
    public void setUp(){
        accountTypeDto = new AccountTypeDto("1", "CUENTA CORRIENTE 2");
        BDDMockito.when(repository.getAll())
                .thenReturn(Flux.just(accountTypeDto));

        BDDMockito.when(repository.getAccountType(ArgumentMatchers.anyString()))
                .thenReturn(Mono.just(accountTypeDto));

    }

    @Test
    @DisplayName("get All accountType")
    void getAll() {
        StepVerifier.create(service.getAll())
                .expectSubscription()
                .expectNext(accountTypeDto)
                .verifyComplete();

    }

    @Test
    @DisplayName("get BY ID accountType")
    void getAccountType() {
        StepVerifier.create(service.getAccountType("1"))
                .expectSubscription()
                .expectNext(accountTypeDto)
                .verifyComplete();

    }

}