package eu.uhk.devschool.shoppinglist.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "eu.uhk.devschool.shoppinglist")
@EnableMongoRepositories(basePackages = "eu.uhk.devschool.shoppinglist")
public class DbSpringConfiguration {
}
