package com.vinisnzy.workshop_mongodb.resources.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {
    public static String decodeParam(String text) {
        return text.replace("+", " ");
    }

    public static Date convertDate(String text, Date defaultValue) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            return sdf.parse(text);
        } catch (ParseException e) {
            return defaultValue;
        }
    }
}
