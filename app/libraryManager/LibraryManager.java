package libraryManager;


import play.mvc.Result;

public interface LibraryManager {

    public Result addBook();

    public Result deleteBook(long id);

    public Result listRemainingBooks();

    public Result borrowBook(String title);

    public Result returnBook();

    public Result addDvd();

    public Result deleteDvd(long id);

    public Result listRemainingDvds();

    public Result borrowDvd(String title);

    public Result returnDvd();

    public Result searchBook(String title);

    public Result searchDvd(String title);
}
