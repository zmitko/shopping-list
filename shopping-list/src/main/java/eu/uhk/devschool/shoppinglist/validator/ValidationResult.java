package eu.uhk.devschool.shoppinglist.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ValidationResult {

    private List<String> errors;

    public ValidationResult() {
        errors = new ArrayList<>();
    }

    public void addError(String error) {
        Objects.requireNonNull(error);
        errors.add(error);
    }

    public void addAll(ValidationResult validationResult) {
        Objects.requireNonNull(validationResult);
        errors.addAll(validationResult.getErrors());
    }

    public List<String> getErrors() {
        return errors;
    }

    public boolean isValid() {
        return errors.isEmpty();
    }
}
