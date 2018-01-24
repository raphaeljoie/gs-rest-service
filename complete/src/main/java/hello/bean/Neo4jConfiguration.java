package hello.bean;

import hello.Application;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@org.springframework.context.annotation.Configuration
@EnableTransactionManagement
public class Neo4jConfiguration {

    public static final String MODEL_PACKAGE_NAME = Application.PACKAGE + ".models";

    @Bean
    public Configuration configuration() {
        Configuration configuration = new Configuration();

        configuration.driverConfiguration()
                .setDriverClassName("org.neo4j.ogm.drivers.bolt.driver.BoltDriver")
                .setURI("bolt://neo4j:password@localhost")
                .setConnectionPoolSize(150);

        return configuration;
    }

    @Bean
    public Neo4jTransactionManager transactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }

    @Bean
    public SessionFactory sessionFactory() {
        return new SessionFactory(configuration(), MODEL_PACKAGE_NAME);
    }
}
