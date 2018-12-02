package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@MappedSuperclass
public abstract class LibraryItem extends Model{

    private String isbn;

    @NotNull
    private String title;

    @NotNull
    private String sector;

    public boolean isAvailable(){
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @NotNull
    private boolean isAvailable;


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

}
