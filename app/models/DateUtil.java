package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class DateUtil extends Model {

    @Id
    @GeneratedValue(generator = "id")
    private Date recordId;

    @NotNull
    private Date borrwedDate;

    private Date returnedDate;

    @NotNull
    private Date publishedDate;

    @OneToOne
    private LibraryItem libraryItem;

    public Date getRecordId() {
        return recordId;
    }

    public void setRecordId(Date recordId) {
        this.recordId = recordId;
    }

    public Date getBorrwedDate() {
        return borrwedDate;
    }

    public void setBorrwedDate(Date borrwedDate) {
        this.borrwedDate = borrwedDate;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }
}
