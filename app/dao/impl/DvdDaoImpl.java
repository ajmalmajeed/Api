package dao.impl;

import com.avaje.ebean.Model;
import dao.DvdDao;
import models.Dvd;

import java.util.List;

public class DvdDaoImpl implements DvdDao {
    public static final Model.Finder<Long,Dvd> find = new Model.Finder<>(Dvd.class);
    @Override
    public Dvd addDvd(Dvd dvdToAdd) {
        dvdToAdd.save();
        return dvdToAdd;
    }

    @Override
    public Dvd findDvdById(long id) {
        return find.where().eq("id",id).findUnique();
    }

    @Override
    public Dvd deleteDvd(Dvd dvdToDelete) {
        dvdToDelete.delete();
        return dvdToDelete;
    }

    @Override
    public List<Dvd> listRemainingDvds() {
        List<Dvd> bookList = find.findList();
        return  bookList;
    }

    @Override
    public Dvd borrowDvd() {
        return null;
    }

    @Override
    public Dvd returnDvd() {
        return null;
    }

    @Override
    public Dvd searchByTitle(String title) {
        return find.where().eq("title",title).findUnique();
    }

    @Override
    public Dvd isAvailbale(String title) {
        Dvd dvdInDb = find.where().eq("title",title).findUnique();
        if(dvdInDb.isAvailable()==true){
            return dvdInDb;
        }
        return null;
    }
}
