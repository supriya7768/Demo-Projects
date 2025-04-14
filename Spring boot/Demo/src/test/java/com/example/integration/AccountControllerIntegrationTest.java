//package com.example.integration;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;
//
//import com.example.model.Account;
//import com.example.repository.AccountRepository;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.test.context.DynamicPropertyRegistry;
//import org.springframework.test.context.DynamicPropertySource;
//import org.testcontainers.containers.PostgreSQLContainer;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class AccountControllerIntegrationTest {
//
//    @LocalServerPort
//    private Integer port;
//
//    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine")
////            .withDatabaseName("testdb")
////            .withUsername("testuser")
////            .withPassword("testpass")
//              ;
//
//    @BeforeAll
//    static void beforeAll() {
//        postgres.start();
//    }
//
//    @AfterAll
//    static void afterAll() {
//        postgres.stop();
//    }
//
//    @DynamicPropertySource
//    static void configureProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", postgres::getJdbcUrl);
//        registry.add("spring.datasource.username", postgres::getUsername);
//        registry.add("spring.datasource.password", postgres::getPassword);
//    }
//
//    @Autowired
//    AccountRepository accountRepository;
//
//    @BeforeEach
//    void setUp() {
//        RestAssured.baseURI = "http://localhost:" + port;
//        accountRepository.deleteAll();
//    }
//
//    @Test
//    void shouldCreateAccount() {
//        Account account = new Account(1, "John Doe", 12345, "New York", 5000);
//
//        given()
//                .contentType(ContentType.JSON)
//                .body(account)
//                .when()
//                .post("/account")
//                .then()
//                .statusCode(201)
//                .body("name", equalTo("John Doe"))
//                .body("city", equalTo("New York"))
//                .body("balance", equalTo(5000));
//    }
//
//
//}
