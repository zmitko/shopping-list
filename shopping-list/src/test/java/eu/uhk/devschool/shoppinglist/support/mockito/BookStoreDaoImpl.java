package eu.uhk.devschool.shoppinglist.support.mockito;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookStoreDaoImpl implements BookStoreDao {

    public Book getBook(String name) {
        // Imagine that here is a real implementation with a database cooperation
        return null;
    }

    public List<Book> getBooks() {
        // Imagine that here is a real implementation with a database cooperation
        return null;
    }

}
