package eu.uhk.devschool.shoppinglist.validator;

import eu.uhk.devschool.shoppinglist.dto.ShoppingItem;
import eu.uhk.devschool.shoppinglist.validator.rule.ShoppingItemValidationRule;
import eu.uhk.devschool.shoppinglist.validator.rule.ShoppingItemValidatorPhase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShoppingItemValidatorImpl implements ShoppingItemValidator {

    @Autowired
    private List<ShoppingItemValidationRule> validationRules;

    @Override
    public ValidationResult prePersist(ShoppingItem shoppingItem) {
        return validate(shoppingItem, ShoppingItemValidatorPhase.PRE_PERSIST);
    }

    @Override
    public ValidationResult preUpdate(ShoppingItem shoppingItem) {
        return validate(shoppingItem, ShoppingItemValidatorPhase.PRE_UPDATE);
    }

    private ValidationResult validate(ShoppingItem shoppingItem, ShoppingItemValidatorPhase shoppingItemValidatorPhase) {
        ValidationResult validationResult = new ValidationResult();
        for (ShoppingItemValidationRule validationRule : validationRules) {
            if (validationRule.support(shoppingItemValidatorPhase)) {
                validationResult.addAll(validationRule.validate(shoppingItem));
            }
        }
        return validationResult;
    }

}
