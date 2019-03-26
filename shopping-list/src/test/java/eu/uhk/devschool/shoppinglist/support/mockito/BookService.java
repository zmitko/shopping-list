package eu.uhk.devschool.shoppinglist.support.mockito;

import java.util.List;

public interface BookService {

    Book findBook(String name);

    List<Book> findAllBooks();

}
