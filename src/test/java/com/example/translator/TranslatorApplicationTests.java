package com.example.translator;

import com.example.translator.actions.TranslateRepositoryEntity;
import com.example.translator.data.TranslateDictionary;
import com.example.translator.data.TranslateDictionaryDto;
import com.example.translator.data.TypeWord;
import com.example.translator.data.WordToTranslateDto;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.FluxExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.with;
import static org.mockito.BDDMockito.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TranslatorApplicationTests {

    @MockBean
    private TranslateRepositoryEntity repository;

//    @Autowired
//    private WebTestClient testClient;


    @Test
    void contextLoads(){

    }

    @Test
    void getFluxGames() {
        given(repository.findByEnglishWord("egg")).willReturn(new TranslateDictionary("1", "jajo", "egg"));
//        WebTestClient.ResponseSpec response = testClient
//                .get()
//                .uri("/api/translator")
////                .body(new WordToTranslateDto("egg", TypeWord.ENGLISH))
//                .exchange()
//                .expectStatus().isOk();
//        RestAssured.get("/api/translator").then().statusCode(200);
        given().contentType("application/json").body(new WordToTranslateDto("egg", TypeWord.ENGLISH)).get("/api/translator").then()
                .assertThat()
                .statusCode(HttpStatus.OK.value());
//                .body("id", equalTo(testMovie.getId()))
//                .body("name", equalTo(testMovie.getName()))
//                .body("synopsis", notNullValue());
//        String games2 = response.returnResult(S.class);
//        Assertions.assertEquals(, games2);
    }
}
