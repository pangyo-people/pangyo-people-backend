package com.pangyopeoplebackend.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Converter
public class DateToStringConverter implements AttributeConverter<String, Date> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DateToStringConverter.class);
    private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd"); /*String to Date (Client -> DB */

    @Override
    public Date convertToDatabaseColumn(String attribute) {
        Date date = null; try {
            date = sf.parse(attribute);
        } catch (ParseException e) {
            LOGGER.error("[ERROR] 문자열을 Date 타입으로 변환하는데 실패하였습니다.", e);
        }
        return date;
    } /*Date to String (DB -> Client*/

    @Override
    public String convertToEntityAttribute(Date dbData) {
        if(dbData != null) {
            return sf.format(dbData);
        }
        else {
            return null;
        }
    }
}

