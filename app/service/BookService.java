package service;

import models.Book;

import java.util.List;

public interface BookService {

    public Book addBook(Book bookToAdd);

    public Book deleteBook(long id);

    public List<Book> listRemainingBooks();

    public Book borrowBook(String title);

    public Book returnBook();

    public Book search(String title);
}
