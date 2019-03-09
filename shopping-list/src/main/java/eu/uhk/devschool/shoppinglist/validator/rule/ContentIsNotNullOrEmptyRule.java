package eu.uhk.devschool.shoppinglist.validator.rule;

import eu.uhk.devschool.shoppinglist.dto.ShoppingItem;
import eu.uhk.devschool.shoppinglist.validator.ValidationResult;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static eu.uhk.devschool.shoppinglist.validator.rule.ShoppingItemValidatorPhase.PRE_PERSIST;
import static eu.uhk.devschool.shoppinglist.validator.rule.ShoppingItemValidatorPhase.PRE_UPDATE;

@Component
public class ContentIsNotNullOrEmptyRule implements ShoppingItemValidationRule {

    private List<ShoppingItemValidatorPhase> supportedPhases = Arrays.asList(PRE_PERSIST, PRE_UPDATE);

    @Override
    public ValidationResult validate(ShoppingItem shoppingItem) {
        ValidationResult validationResult = new ValidationResult();
        if (shoppingItem.getContent() == null || shoppingItem.getContent().isEmpty()) {
            validationResult.addError(String.format("Shopping Item content is null or empty for id %s", shoppingItem.getContent()));
        }
        return validationResult;
    }

    @Override
    public boolean support(ShoppingItemValidatorPhase supportedPhase) {
        return supportedPhases.contains(supportedPhase);
    }

}
