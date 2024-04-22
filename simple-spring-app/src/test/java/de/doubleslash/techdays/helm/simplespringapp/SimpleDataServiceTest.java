package de.doubleslash.techdays.helm.simplespringapp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@Testcontainers
class SimpleDataServiceTest {
    @Autowired
    private SimpleDataService simpleDataService;

    @Container
    private static final PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:16.2")
            .withDatabaseName("test")
            .withUsername("test")
            .withPassword("test");


    @BeforeAll
    static void beforeAll() {
        // Start the container before any tests run
        postgreSQLContainer.start();

        // Get JDBC URL of the PostgreSQL container
        String jdbcUrl = postgreSQLContainer.getJdbcUrl();

        // Override datasource properties to use container's settings
        System.setProperty("spring.datasource.url", jdbcUrl);
        System.setProperty("spring.datasource.username", "test");
        System.setProperty("spring.datasource.password", "test");
    }

    @AfterAll
    static void afterAll() {
        // Stop the container after all tests are finished
        postgreSQLContainer.stop();
    }

    @Test
    void testMyService() {
        // Call your service method and assert results
        // Here you can test any method of your service
        assertEquals(0, simpleDataService.findAll().size());

        SimpleDataEntity dataEntity = simpleDataService.save(new SimpleDataEntity("test"));
        assertEquals(1, simpleDataService.findAll().size());

        assertEquals(dataEntity, simpleDataService.findAll().getFirst());
        assertEquals("test", simpleDataService.findById(dataEntity.getId()).getName());
    }
}
