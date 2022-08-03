package com.bank.initial.application.rest;

import com.bank.initial.domain.entities.PersonDto;
import com.bank.initial.domain.services.PersonService;
import com.bank.initial.infraestructure.repositories.PersonRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.blockhound.BlockHound;
import reactor.blockhound.BlockingOperationError;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;


@ExtendWith(SpringExtension.class)
@WebFluxTest
@Import(PersonService.class)
class PersonControllerTest {

    @MockBean
    private PersonRepository repository;

    @Autowired
    private WebTestClient client;

    private PersonDto personDto;

    @BeforeAll
    public static void blockHoundSetup() {
        BlockHound.install();
    }

    @BeforeEach
    public void setUp() {
        personDto= new PersonDto("1", "MARIELLA","ESCUDERO","46737093","DNI","NATURAL","AV. JOSE GRANDA","MARIELLA@GMAIL.COM","985698569");
        BDDMockito.when(repository.getAll())
                .thenReturn(Flux.just(personDto));
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
    @DisplayName("GetAll returns a flux of person")
    public void getAll() {
        client
                .get()
                .uri("/api/person/getAll")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody()
                .jsonPath("1").isEqualTo(personDto.getId())
                .jsonPath("MARIELLA").isEqualTo(personDto.getName())
                .jsonPath("ESCUDERO").isEqualTo(personDto.getLastName());
    }



}