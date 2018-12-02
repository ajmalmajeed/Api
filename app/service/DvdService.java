package service;

import models.Dvd;

import java.util.List;

public interface DvdService {

    public Dvd addDvd(Dvd dvdToAdd);

    public Dvd deleteDvd(long id);

    public List<Dvd> listRemainingDvds();

    public Dvd borrowDvd(String title);

    public Dvd returnDvd();

    public Dvd search(String title);
}
