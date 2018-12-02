package dao.impl;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model;
import dao.BookDao;
import models.Book;

import java.util.List;

public class BookDaoImpl implements BookDao {
    public static final Model.Finder<Long,Book> find = new Model.Finder<>(Book.class);

    @Override
    public Book addBook(Book bookToAdd) {
        bookToAdd.save();
        return null;
    }

    @Override
    public Book findBookById(long id) {
        return find.where().eq("id",id).findUnique();
    }

    @Override
    public Book deleteBook(Book bookToDeelete) {
        bookToDeelete.delete();
        return bookToDeelete;
    }

    @Override
    public List<Book> listRemainingBooks() {
        List<Book> bookList = find.findList();
        return bookList;
    }

    @Override
    public Book borrowBook() {
        return null;
    }

    @Override
    public Book returnBook() {
        return null;
    }

    @Override
    public Book searchByTitle(String title) {
        return find.where().eq("title",title).findUnique();
    }

    @Override
    public Book isAvailable(String title) {
        Book bookInDb = find.where().eq("title",title).findUnique();
        if(bookInDb.isAvailable()==true){
            return bookInDb;
        }
        return null;
    }
}
