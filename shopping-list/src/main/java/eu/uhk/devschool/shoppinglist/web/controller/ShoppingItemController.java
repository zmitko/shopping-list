package eu.uhk.devschool.shoppinglist.web.controller;

import eu.uhk.devschool.shoppinglist.dto.ShoppingItem;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static eu.uhk.devschool.shoppinglist.web.constant.WebConstant.SHOPPING_ITEM_URL;
import static eu.uhk.devschool.shoppinglist.web.constant.WebConstant.SHOPPING_LIST_URL;

@RestController
public class ShoppingItemController {

    @GetMapping(path = SHOPPING_LIST_URL, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ShoppingItem> getShoppingList() {
        // TODO get all shoppingItems from database
        List<ShoppingItem> shoppingItems = new ArrayList<>();
        ShoppingItem rohlik = new ShoppingItem("Rohlik", (short) 3);
        ShoppingItem houska = new ShoppingItem("Houska", (short) 2);
        shoppingItems.add(rohlik);
        shoppingItems.add(houska);
        return shoppingItems;
    }

    @PostMapping(path = SHOPPING_ITEM_URL, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ShoppingItem createShoppingItem(@RequestBody ShoppingItem shoppingItem) {
        // TODO create shoppingItem in database
        shoppingItem.setId(new Random().nextLong());
        return shoppingItem;
    }

    @PutMapping(path = SHOPPING_ITEM_URL, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ShoppingItem updateShoppingItem(@RequestBody ShoppingItem shoppingItem) {
        // TODO update shoppingItem in database
        shoppingItem.setId(new Random().nextLong());
        return shoppingItem;
    }

    @DeleteMapping(path = SHOPPING_ITEM_URL, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ShoppingItem deleteShoppingItem(@RequestBody ShoppingItem shoppingItemId) {
        // TODO delete shoppingItem in database
        return new ShoppingItem();
    }
}
