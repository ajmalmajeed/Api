package dao;

import models.Book;

import java.util.List;

public interface BookDao {

    public Book addBook(Book bookToAdd);

    public Book findBookById(long id);

    public Book deleteBook(Book bookToDeelete);

    public List<Book> listRemainingBooks();

    public Book borrowBook();

    public Book returnBook();

    public Book searchByTitle(String title);

    public Book isAvailable(String title);

}
