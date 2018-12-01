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

    @OneToOne(mappedBy = "reader",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private DateUtil publishedDate;


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

    public DateUtil getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(DateUtil publishedDate) {
        this.publishedDate = publishedDate;
    }

    /*public Date getDateBorrowed() {
        return dateBorrowed;
    }

    public void setDateBorrowed(Date dateBorrowed) {
        this.dateBorrowed = dateBorrowed;
    }
*/
    /*public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }*/
}
