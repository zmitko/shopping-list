package eu.uhk.devschool.shoppinglist.support.mockito;

import java.util.List;

public interface BookStoreDao {

    Book getBook(String name);

    List<Book> getBooks();
}
