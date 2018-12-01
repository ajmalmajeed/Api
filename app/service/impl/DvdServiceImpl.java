package service.impl;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import dao.DvdDao;
import models.Dvd;
import service.DvdService;

import java.util.List;

public class DvdServiceImpl implements DvdService {

    @Inject
    @Named("dvdDao")
    private DvdDao dvdDao;

    @Override
    public Dvd addDvd(Dvd dvdToAdd) {
        return dvdDao.addDvd(dvdToAdd);
    }

    @Override
    public Dvd deleteDvd(long id) {
        return dvdDao.deleteDvd(dvdDao.findDvdById(id));
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
