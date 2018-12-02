package dao;

import models.Dvd;

import java.util.List;

public interface DvdDao {

    public Dvd addDvd(Dvd dvdToAdd);

    public Dvd findDvdById(long id);

    public Dvd deleteDvd(Dvd dvdToDelete);

    public List<Dvd> listRemainingDvds();

    public Dvd borrowDvd();

    public Dvd returnDvd();

    public Dvd searchByTitle(String Title);

    public Dvd isAvailbale(String title);
}
