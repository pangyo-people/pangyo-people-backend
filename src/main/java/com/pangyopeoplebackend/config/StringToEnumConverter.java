package com.pangyopeoplebackend.config;

import com.pangyopeoplebackend.domain.OrgCategory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.GenericConverter;

public class StringToEnumConverter implements Converter<String, OrgCategory> {
    @Override
    public OrgCategory convert(String source) {
        return OrgCategory.valueOf(source.toUpperCase());
    }
}
