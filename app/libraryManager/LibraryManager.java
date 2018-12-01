package libraryManager;

import javax.xml.transform.Result;

public interface LibraryManager {

    public Result addBook();

    public Result deleteBook(long id);

    public Result listRemainingBooks();

    public Result borrowBook();

    public Result returnBook();

    public Result addDvd();

    public Result deleteDvd(long id);

    public Result listRemainingDvds();

    public Result borrowDvd();

    public Result returnDvd();


}
