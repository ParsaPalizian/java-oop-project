package com.company.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtility {

    public  static LocalDate parseStringToLocalDate(String str) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public  static LocalDateTime parseStringToLocalDateTime(String str) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }



}
