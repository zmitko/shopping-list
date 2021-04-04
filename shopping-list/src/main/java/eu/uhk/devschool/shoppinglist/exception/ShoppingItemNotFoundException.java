package eu.uhk.devschool.shoppinglist.exception;

public class ShoppingItemNotFoundException extends RuntimeException {
    public ShoppingItemNotFoundException(Long id) {
        super("Could not find shopping item " + id);
    }
}
