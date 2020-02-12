package com.fjx.spring.util;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyConverter implements Converter<String,Date> {
    public Date convert(String source) {
        try {
            SimpleDateFormat dp = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dp.parse(source);
            return date;
        } catch (Exception e) {
            throw new RuntimeException("转换错误");
        }
    }
}
