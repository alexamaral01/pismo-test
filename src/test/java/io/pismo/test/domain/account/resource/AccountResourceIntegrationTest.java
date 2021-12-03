package io.pismo.test.domain.account.resource;

import io.pismo.test.core.resource.AbstractBaseIntegration;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountResourceIntegrationTest {

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

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void shouldReturnAccoutWhenCreated() throws Exception {
        given()
                .contentType("application/json")
                .body("{ \"document_number\": \"123562234\"}")
                .when()
                .post("/accounts")
                .then()
                .statusCode(200)
                .body("account_id", Matchers.notNullValue())
                .body("document_number", Matchers.is("123562234"));
    }

    @Test
    public void shouldReturnAccoutWhenAccountId() throws Exception {
        Long accountId = given()
                .contentType("application/json")
                .body("{ \"document_number\": \"1235622347\"}")
                .when()
                .post("/accounts")
                .body().jsonPath().getLong("account_id");

        given()
                .contentType("application/json")
                .when()
                .get("/accounts/"+accountId)
                .then()
                .statusCode(200)
                .body("account_id", Matchers.is(accountId.intValue()))
                .body("document_number", Matchers.is("1235622347"));
    }

}