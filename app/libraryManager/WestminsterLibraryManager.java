package libraryManager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Book;
import models.Dvd;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import service.BookService;
import service.DvdService;
import util.JsonServiceUtil;
import util.ResponseWrapper;

import javax.inject.Inject;
import java.util.List;

public class WestminsterLibraryManager extends Controller implements LibraryManager {

    @Inject
    ObjectMapper objectMapper;

    @Inject
    BookService bookService;

    @Inject
    DvdService dvdService;

    @Override
    @BodyParser.Of(BodyParser.Json.class)
    public Result addBook() {

        JsonNode jsonNode = request().body().asJson();

            Book bookToAdd = null;

        try {
            bookToAdd = objectMapper.treeToValue(jsonNode, Book.class);
            Book addedBook = bookService.addBook(bookToAdd);

            return ok(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("Book added", addedBook)));


        } catch (JsonProcessingException e) {

            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Result deleteBook(long id) {
        try{
             Book bookToDelete = bookService.deleteBook(id);
            if (bookToDelete != null) {
                return ok(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("Book deleted", bookToDelete)));
            }else {
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Result addDvd() {
        JsonNode jsonNode = request().body().asJson();

        Dvd dvdToAdd = null;

        try {
            dvdToAdd = objectMapper.treeToValue(jsonNode, Dvd.class);
            Dvd addedDvd = dvdService.addDvd(dvdToAdd);

            return ok(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("DVD added", addedDvd)));

        } catch (JsonProcessingException e) {

            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Result deleteDvd(long id) {
        try{
            Book bookToDelete = bookService.deleteBook(id);
            if (bookToDelete != null) {
                return ok(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("DVD deleted", bookToDelete)));
            }else {
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Result listRemainingBooks() {
        List<Book> remainingBooks = bookService.listRemainingBooks();
        if(remainingBooks ==null){
            return ok(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("All Books", remainingBooks)));
        }
    return badRequest(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("Failed", null)));
    }

    @Override
    public Result listRemainingDvds() {
        List<Book> remainingDvds = bookService.listRemainingBooks();
        if(remainingDvds ==null){
            return ok(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("All Dvds", remainingDvds)));
        }
        return badRequest(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("Failed", null)));
    }

    @Override
    public Result borrowBook(String title) {
        Book bookToBorrow = bookService.borrowBook(title);
        if(bookToBorrow !=null){
            return ok(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("Borrowed", bookToBorrow)));
        }
        return badRequest(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("Item Not Available", null)));
    }

    @Override
    public Result borrowDvd(String title) {
        Dvd dvdToBorrow = dvdService.borrowDvd(title);
        if(dvdToBorrow !=null){
            return ok(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("Borrowed", dvdToBorrow)));
        }
        return badRequest(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("Item Not Available", null)));
    }

    @Override
    public Result returnBook() {
        return null;
    }

    @Override
    public Result returnDvd() {
        return null;
    }

    @Override
    public Result searchBook(String title) {
        Book searchedBook = bookService.search(title);
        if(searchedBook ==null){
            return ok(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("Found in DB",searchedBook)));
        }
        return badRequest(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("Failed", null)));
    }

    @Override
    public Result searchDvd(String title) {
        Dvd searcherDvd = dvdService.search(title);
        if(searcherDvd ==null){
            return ok(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("Found in DB", searcherDvd)));
        }
        return badRequest(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("Failed", null)));
    }
}
