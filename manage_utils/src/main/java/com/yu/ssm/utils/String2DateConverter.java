package com.yu.ssm.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.springframework.core.convert.converter.Converter;

public class String2DateConverter implements Converter<String, Date>{

    @Override
    public Date convert(String dateString) {
        System.out.println("进入String2DateConverter转换器了,开始进行转换......");
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try {
            date=  format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}