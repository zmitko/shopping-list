package eu.uhk.devschool.shoppinglist.advices;
import eu.uhk.devschool.shoppinglist.exception.ShoppingItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc
 
@ControllerAdvice
class ShoppingItemNotFoundAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ShoppingItemNotFoundException.class)
    @ResponseBody ErrorInfo
    handleBadRequest(HttpServletRequest req, Exception ex) {
        return new ErrorInfo(req.getRequestURL(), ex);
    }
}