package eu.uhk.devschool.shoppinglist.validator.rule;

import eu.uhk.devschool.shoppinglist.dto.ShoppingItem;
import eu.uhk.devschool.shoppinglist.validator.ValidationResult;

public interface ShoppingItemValidationRule {

    ValidationResult validate(ShoppingItem shoppingItem);

    boolean support(ShoppingItemValidatorPhase supportedPhase);

}
