package eu.uhk.devschool.shoppinglist.web.controller;

import eu.uhk.devschool.shoppinglist.dto.ShoppingItem;
import eu.uhk.devschool.shoppinglist.service.ShoppingItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static eu.uhk.devschool.shoppinglist.web.constant.WebConstant.SHOPPING_ITEM_URL;
import static eu.uhk.devschool.shoppinglist.web.constant.WebConstant.SHOPPING_LIST_URL;

@CrossOrigin
@RestController
public class ShoppingItemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingItemController.class);

    @Autowired
    private ShoppingItemService shoppingItemService;

    @GetMapping(path = SHOPPING_LIST_URL, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ShoppingItem> getShoppingList() {
        LOGGER.info("GET request init");
        return shoppingItemService.getAllItems();
    }

    @PostMapping(path = SHOPPING_ITEM_URL, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ShoppingItem createShoppingItem(@RequestBody ShoppingItem shoppingItem) {
        LOGGER.info("Received POST request with body {}", shoppingItem);
        return shoppingItemService.addShoppingItem(shoppingItem);
    }

    @PutMapping(path = SHOPPING_ITEM_URL, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ShoppingItem updateShoppingItem(@RequestBody ShoppingItem shoppingItem) {
        LOGGER.info("Received PUT request with body {}", shoppingItem);
        return shoppingItemService.updateShoppingItem(shoppingItem);
    }

    @DeleteMapping(path = SHOPPING_ITEM_URL, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ShoppingItem deleteShoppingItem(@RequestBody ShoppingItem shoppingItemId) {
        LOGGER.info("Received DELETE request with body {}", shoppingItemId);
        return shoppingItemService.deleteShoppingItem(shoppingItemId);
    }
}
