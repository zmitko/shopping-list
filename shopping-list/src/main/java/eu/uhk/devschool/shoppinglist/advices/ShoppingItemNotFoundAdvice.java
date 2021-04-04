package eu.uhk.devschool.shoppinglist.advices;

import eu.uhk.devschool.shoppinglist.exception.ShoppingItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ShoppingItemNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ShoppingItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String shoppingItemNotFoundHandler(ShoppingItemNotFoundException ex) {
        return ex.getMessage();
    }
}
