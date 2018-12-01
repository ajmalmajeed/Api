package dao.impl;

import com.avaje.ebean.Model;
import dao.DvdDao;
import models.Dvd;

import java.util.List;

public class DvdDaoImpl implements DvdDao {
    public static final Model.Finder<Long,Dvd> findd = new Model.Finder<>(Dvd.class);
    @Override
    public Dvd addDvd(Dvd dvdToAdd) {
        dvdToAdd.save();
        return dvdToAdd;
    }

    @Override
    public Dvd findDvdById(long id) {
        return findd.where().eq("id",id).findUnique();
    }

    @Override
    public Dvd deleteDvd(Dvd dvdToDelete) {
        dvdToDelete.delete();
        return dvdToDelete;
    }

    @Override
    public List<Dvd> listRemainingDvds() {
        return null;
    }

    @Override
    public Dvd borrowDvd() {
        return null;
    }

    @Override
    public Dvd returnDvd() {
        return null;
    }
}
