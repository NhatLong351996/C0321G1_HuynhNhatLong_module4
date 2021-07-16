package com.codegym.model.service;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.TimeZone;
@Service
public class DateServiceImpl implements DateService {
    public Date getTimeByTimeZone(String city) {
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locale = TimeZone.getTimeZone(city);
        long locale_time = date.getTime() +
                (locale.getRawOffset() - local.getRawOffset());
        date.setTime(locale_time);
        return date;
    }

}
