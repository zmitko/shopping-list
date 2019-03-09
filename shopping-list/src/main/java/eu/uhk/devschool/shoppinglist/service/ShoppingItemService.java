package eu.uhk.devschool.shoppinglist.service;

import eu.uhk.devschool.shoppinglist.dto.ShoppingItem;
import eu.uhk.devschool.shoppinglist.dto.ShoppingItemCategory;

import java.util.List;

public interface ShoppingItemService {

    /**
     * Method loads all available {@link eu.uhk.devschool.shoppinglist.dto.ShoppingItem} records.
     */
    List<ShoppingItem> getAllItems();

    /**
     * Method loads all available {@link eu.uhk.devschool.shoppinglist.dto.ShoppingItem} records by specific category.
     */
    List<ShoppingItem> getItemsByCategory(ShoppingItemCategory category);

    /**
     * Creates a new {@link eu.uhk.devschool.shoppinglist.dto.ShoppingItem} record for a Shopping List.
     */
    ShoppingItem addShoppingItem(ShoppingItem item);

    /**
     * Updates a {@link eu.uhk.devschool.shoppinglist.dto.ShoppingItem} record.
     * @param shoppingItem
     */
    ShoppingItem updateShoppingItem(ShoppingItem shoppingItem);

    /**
     * Deletes a {@link eu.uhk.devschool.shoppinglist.dto.ShoppingItem} record.
     * @param shoppingItemId
     */
    ShoppingItem deleteShoppingItem(ShoppingItem shoppingItemId);
}
