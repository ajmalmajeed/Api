package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Reader extends Model {

    @Id
    @GeneratedValue(generator = "id")
    public int readerId;

    @NotNull
    public String readerName;

    @NotNull
    public String readerMobileNum;

    @NotNull
    public String readerEmail;

    @OneToMany(mappedBy = "reader",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Dvd> dvd;

    @OneToMany(mappedBy = "reader",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> book;

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getReaderMobileNum() {
        return readerMobileNum;
    }

    public void setReaderMobileNum(String readerMobileNum) {
        this.readerMobileNum = readerMobileNum;
    }

    public String getReaderEmail() {
        return readerEmail;
    }

    public void setReaderEmail(String readerEmail) {
        this.readerEmail = readerEmail;
    }

    /*public List<LibraryItem> getLibraryItem() {
        return libraryItem;
    }

    public void setLibraryItem(List<LibraryItem> libraryItem) {
        this.libraryItem = libraryItem;
    }*/
}
