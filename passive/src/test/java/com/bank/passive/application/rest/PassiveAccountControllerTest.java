package com.bank.passive.application.rest;

import com.bank.passive.domain.entities.PassiveAccountDto;
import com.bank.passive.domain.services.PassiveAccountService;
import com.bank.passive.infraestructure.repositories.PassiveAccountRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.blockhound.BlockHound;
import reactor.blockhound.BlockingOperationError;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import org.springframework.http.MediaType;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@WebFluxTest
@Import(PassiveAccountService.class)
class PassiveAccountControllerTest {

    @MockBean
    private PassiveAccountRepository repository;

    @Autowired
    private WebTestClient client;

    private PassiveAccountDto passiveAccountDto;

    @BeforeAll
    public static void blockHoundSetup() {
        BlockHound.install();
    }

    @BeforeEach
    public void setUp() {
        passiveAccountDto= new PassiveAccountDto("25", "123456789","25698563","1", "CUENTA CORRIENTE",Double.parseDouble("1"),1,"2022-05-20",Double.parseDouble("100"));
        BDDMockito.when(repository.savePassiveAccount(Mono.just(passiveAccountDto)))
                .thenReturn(Mono.just(passiveAccountDto));
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


    @Test
    @DisplayName("Creating a account")
    void createPassiveAccount() {
        client.post()
                .uri("/api/passive/create")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(Mono.just(passiveAccountDto)))
                .exchange()
                .expectStatus().isCreated()
                .expectBody(PassiveAccountDto.class)
                .isEqualTo(passiveAccountDto);
    }
}