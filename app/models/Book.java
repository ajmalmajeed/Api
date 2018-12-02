package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Book extends LibraryItem{

    @Id
    public String id;

    @NotNull
    public String authorName;

    @NotNull
    public String publisherName;

    @NotNull
    public long numberOfPages;

    @ManyToOne(cascade = CascadeType.ALL)
    private Reader reader;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public long getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(long numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
