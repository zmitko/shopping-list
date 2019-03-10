package eu.uhk.devschool.shoppinglist;

import eu.uhk.devschool.shoppinglist.configuration.CoreSpringConfiguration;
import eu.uhk.devschool.shoppinglist.configuration.DbSpringConfiguration;
import eu.uhk.devschool.shoppinglist.configuration.WebSpringConfiguration;
import eu.uhk.devschool.shoppinglist.dto.ShoppingItem;
import eu.uhk.devschool.shoppinglist.dto.ShoppingItemState;
import eu.uhk.devschool.shoppinglist.repository.ShoppingItemMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Import;
import org.springframework.context.event.EventListener;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Import({CoreSpringConfiguration.class, WebSpringConfiguration.class, DbSpringConfiguration.class})
public class ShoppingListApplication {

    @Autowired
    private ShoppingItemMongoRepository shoppingItemMongoRepository;

    public static void main(String[] args) {
        SpringApplication.run(ShoppingListApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
//	    shoppingItemMongoRepository.deleteAll();
        List<ShoppingItem> shoppingItems = Arrays.asList(
                new ShoppingItem(BigInteger.valueOf(1), "papousek", (short) 2, ShoppingItemState.NEW),
                new ShoppingItem(BigInteger.valueOf(2), "kocka", (short) 1, ShoppingItemState.NEW),
                new ShoppingItem(BigInteger.valueOf(3), "pes", (short) 1, ShoppingItemState.NEW)
        );
        shoppingItemMongoRepository.saveAll(shoppingItems);
    }
}
