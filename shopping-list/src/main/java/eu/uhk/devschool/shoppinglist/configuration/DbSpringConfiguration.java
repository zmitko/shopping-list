package eu.uhk.devschool.shoppinglist.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "eu.uhk.devschool.shoppinglist")
public class DbSpringConfiguration {
}
