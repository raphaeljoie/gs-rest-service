package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(hello.bean.Neo4jConfiguration.MODEL_PACKAGE_NAME)
public class Application {

    public static final String PACKAGE = "hello";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
