package io.pismo.test.domain.transaction.resource;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static io.restassured.RestAssured.given;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransationResourceIntegrationTest{

    @Container
    static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:12")
            .withUsername("testcontainers")
            .withPassword("testcontainers")
            .withDatabaseName("tescontainers");

    static {
        postgresContainer.start();
    }

    @DynamicPropertySource
    private static void setDatasourceProperties(DynamicPropertyRegistry registry) {

        // JDBC DataSource Example
        registry.add("spring.datasource.url", postgresContainer::getJdbcUrl);
        registry.add("spring.datasource.password", postgresContainer::getPassword);
        registry.add("spring.datasource.username", postgresContainer::getUsername);
    }

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void createTransation() {

        Long accountId = given()
                .contentType("application/json")
                .body("{ \"document_number\": \"00001235622347\"}")
                .when()
                .post("/accounts")
                .body().jsonPath().getLong("account_id");

        given()
                .contentType("application/json")
                .body("{\"account_id\": "+ accountId + "," +
                        "\"operation_type_id\": 3,\n" +
                        "\"amount\": 123.45" +
                        "}")
                .log().all()
                .when()
                .post("/transactions")
                .then()
                .statusCode(200)
                .log().all();
    }
}