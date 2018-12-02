package dao.impl;

import dao.DateUtilDao;
import models.DateUtil;

public class DateUtilImpl implements DateUtilDao {
    @Override
    public DateUtil add(DateUtil record) {
        record.save();
        return record;
    }
}
