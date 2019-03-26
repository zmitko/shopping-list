package eu.uhk.devschool.shoppinglist.support.mockito;

public class BookNotFoundException extends RuntimeException {

    BookNotFoundException(String message) {
        super(message);
    }
}
