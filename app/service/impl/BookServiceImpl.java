package service.impl;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import dao.BookDao;
import models.Book;
import service.BookService;

import javax.xml.transform.Result;
import java.util.List;

public class BookServiceImpl implements BookService {

    @Inject
    @Named("bookDao")
    private BookDao bookDao;

    @Override
    public  Book addBook(Book bookToAdd){
    return bookDao.addBook(bookToAdd);
    }

    @Override
    public Book deleteBook(long id) {
        return bookDao.deleteBook(bookDao.findBookById(id));
    }

    @Override
    public List<Book> listRemainingBooks(){

    }
    @Override
    public Book borrowBook(){

    }
    @Override
    public Book returnBook(){

    }
}
