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

    private String title;

    @NotNull
    private Date borrwedDate;

    private Date returnedDate;

    @NotNull
    private Date publishedDate;


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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
