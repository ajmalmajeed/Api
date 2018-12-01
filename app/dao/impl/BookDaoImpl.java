package dao.impl;

import com.avaje.ebean.Model;
import dao.BookDao;
import models.Book;

import java.util.List;

public class BookDaoImpl implements BookDao {
    public static final Model.Finder<Long,Book> findd = new Model.Finder<>(Book.class);

    @Override
    public Book addBook(Book bookToAdd) {
        bookToAdd.save();
        return null;
    }

    @Override
    public Book findBookById(long id) {
        return findd.where().eq("id",id).findUnique();
    }

    @Override
    public Book deleteBook(Book bookToDeelete) {
        bookToDeelete.delete();
        return bookToDeelete;
    }

    @Override
    public List<Book> listRemainingBooks() {
        return null;
    }

    @Override
    public Book borrowBook() {
        return null;
    }

    @Override
    public Book returnBook() {
        return null;
    }
}
