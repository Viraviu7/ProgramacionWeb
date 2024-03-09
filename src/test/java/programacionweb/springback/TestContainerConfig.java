package programacionweb.springback;

import org.testcontainers.containers.PostgreSQLContainer;

public class TestContainerConfig {
    PostgreSQLContainer<?> postgreSQLContainer(){
        return new PostgreSQLContainer<>("postgres:latest");
    }
}
