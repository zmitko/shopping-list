package eu.uhk.devschool.shoppinglist;

import eu.uhk.devschool.shoppinglist.support.mockito.Book;
import eu.uhk.devschool.shoppinglist.support.mockito.BookNotFoundException;
import eu.uhk.devschool.shoppinglist.support.mockito.BookServiceImpl;
import eu.uhk.devschool.shoppinglist.support.mockito.BookStoreDao;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

public class BookServiceMockitoTest {

    // TODO vypracovat testy pomoci Mockito nad prikladem BookService, mockovat se bude BookStoreDao

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private List<Book> bookList = Arrays.asList(
            new Book("Bohemian Rhapsody", "Owen Williams"),
            new Book("Promoce UHK", "UHK")
    );

    @Mock
    private BookStoreDao bookStoreDao;

    @InjectMocks
    private BookServiceImpl bookServiceImpl = new BookServiceImpl();

    private Book bookToFind = bookList.get(0);

    @Before
    public void setup() {
        when(bookStoreDao.getBook(bookToFind.getName()))
                .thenReturn(bookToFind);
    }

    @Test
    public void findBookTest() {
        Book book = bookServiceImpl.findBook(bookToFind.getName());
        assertThat(book, is(equalTo(bookToFind)));
    }

    @Test
    public void testFindAll() {
        when(bookStoreDao.getBooks()).thenReturn(bookList);
        List<Book> books = bookServiceImpl.findAllBooks();
        assertThat(books, containsInAnyOrder(bookList.toArray()));
    }

    @Test
    public void testFindAllEmptyCollection() {
        List<Book> books = bookServiceImpl.findAllBooks();
        assertThat(books, is(empty()));
    }

    @Test(expected = BookNotFoundException.class)
    public void bookNotFoundTest() {
        Book book = bookServiceImpl.findBook("non-existing book");
        assertThat(book, is(nullValue()));
    }
}
