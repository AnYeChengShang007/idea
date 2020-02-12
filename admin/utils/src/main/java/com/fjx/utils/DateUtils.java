package com.fjx.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String formate(Date date,String pat){
        SimpleDateFormat df = new SimpleDateFormat(pat);
        return df.format(date);
    }
}
