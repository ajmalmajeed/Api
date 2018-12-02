package service.impl;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import dao.DateUtilDao;
import dao.DvdDao;
import models.DateUtil;
import models.Dvd;
import service.DvdService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DvdServiceImpl implements DvdService {

    @Inject
    @Named("dvdDao")
    private DvdDao dvdDao;

    @Inject
    @Named("dateUtilDao")
    private DateUtilDao dateUtilDao;

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
        return dvdDao.listRemainingDvds();
    }

    @Override
    public Dvd borrowDvd(String title) {
        Dvd dvdInDb = dvdDao.isAvailbale(title);
        if(dvdInDb !=null){
            Date date = new Date();
            DateUtil record = new DateUtil();
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DATE, 5);
            Date returnDate = c.getTime();
            record.setBorrwedDate(date);
            record.setReturnedDate(returnDate);
            record.setTitle(title);
            dateUtilDao.add(record);
            return dvdInDb;
        }
        return null;
    }

    @Override
    public Dvd returnDvd() {
        return null;
    }

    @Override
    public Dvd search(String title) {
        return dvdDao.searchByTitle(title);
    }
}
