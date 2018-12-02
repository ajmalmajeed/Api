package service.impl;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import dao.BookDao;
import dao.DateUtilDao;
import models.Book;
import models.DateUtil;
import service.BookService;

import javax.xml.transform.Result;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BookServiceImpl implements BookService {

    @Inject
    @Named("bookDao")
    private BookDao bookDao;

    @Inject
    @Named("dateUtilDao")
    private DateUtilDao dateUtilDao;

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
        return bookDao.listRemainingBooks();
    }
    @Override
    public Book borrowBook(String title){
        Book bookInDb = bookDao.isAvailable(title);
        if(bookInDb !=null){
            Date date = new Date();
            DateUtil record = new DateUtil();
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DATE, 7);
            Date returnDate = c.getTime();
            record.setBorrwedDate(date);
            record.setReturnedDate(returnDate);
            record.setTitle(title);
            dateUtilDao.add(record);
            return bookInDb;
        }
        return null;
    }
    @Override
    public Book returnBook(){
    return null;
    }

    @Override
    public Book search(String title) {
        return bookDao.searchByTitle(title);
    }
}
