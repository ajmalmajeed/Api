package libraryManager.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import libraryManager.LibraryManager;
import models.Book;
import models.Dvd;
import play.mvc.BodyParser;
import play.mvc.Controller;
import service.BookService;
import service.DvdService;

import javax.inject.Inject;
import javax.xml.transform.Result;
import javax.xml.ws.ResponseWrapper;

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

            return ok(new ResponseWrapper(
                    ResponseMessage.ADDED,
                    StatusCode.ADDED_SUCCESSFULLY,
                    addedQr)
                    .jsonSerialize());

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
                return ok(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("All contacts", newContactList)));
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

            return ok(new ResponseWrapper(
                    ResponseMessage.ADDED,
                    StatusCode.ADDED_SUCCESSFULLY,
                    addedQr)
                    .jsonSerialize());

        } catch (JsonProcessingException e) {

            e.printStackTrace();
            return null;
        }

        return null;
    }

    @Override
    public Result deleteDvd(long id) {
        try{
            Book bookToDelete = bookService.deleteBook(id);
            if (bookToDelete != null) {
                return ok(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("All contacts", newContactList)));
            }else {
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Result listRemainingBooks() {
        return null;
    }

    @Override
    public Result listRemainingDvds() {
        return null;
    }

    @Override
    public Result borrowBook() {
        return null;
    }

    @Override
    public Result borrowDvd() {
        return null;
    }

    @Override
    public Result returnBook() {
        return null;
    }

    @Override
    public Result returnDvd() {
        return null;
    }
}
