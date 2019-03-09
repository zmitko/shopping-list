package eu.uhk.devschool.shoppinglist.validator;

import eu.uhk.devschool.shoppinglist.dto.ShoppingItem;

public interface ShoppingItemValidator {

    ValidationResult prePersist(ShoppingItem shoppingItem);

    ValidationResult preUpdate(ShoppingItem shoppingItem);
}
