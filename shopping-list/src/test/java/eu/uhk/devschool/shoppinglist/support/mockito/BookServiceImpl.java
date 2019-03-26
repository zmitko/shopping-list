package eu.uhk.devschool.shoppinglist.support.mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class BookServiceImpl implements BookService {

    private BookStoreDao bookStoreDao;

    @Override
    public Book findBook(String name) {
        Book book = bookStoreDao.getBook(name);
        if (book == null) {
            throw new BookNotFoundException("Book library is empty");
        }
        return book;
    }

    @Override
    public List<Book> findAllBooks() {
        List<Book> books = bookStoreDao.getBooks();
        if (books == null) {
            return Collections.emptyList();
        }
        return books;
    }

    public BookServiceImpl() {
    }

    @Autowired
    public BookServiceImpl(BookStoreDao bookStoreDao) {
        this.bookStoreDao = bookStoreDao;
    }

    public void setBookStoreDao(BookStoreDao bookStoreDao) {
        this.bookStoreDao = bookStoreDao;
    }
}