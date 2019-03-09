package eu.uhk.devschool.shoppinglist;

import eu.uhk.devschool.shoppinglist.configuration.CoreSpringConfiguration;
import eu.uhk.devschool.shoppinglist.configuration.DbSpringConfiguration;
import eu.uhk.devschool.shoppinglist.configuration.WebSpringConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({CoreSpringConfiguration.class, WebSpringConfiguration.class, DbSpringConfiguration.class})
public class ShoppingListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingListApplication.class, args);
	}
}
