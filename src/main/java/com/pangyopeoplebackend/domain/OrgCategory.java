package com.pangyopeoplebackend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import javax.persistence.AttributeConverter;
import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum OrgCategory {
    CLUBS(0, "동아리"),
    EDUCATIONS(1, "교육"),
    MEETINGS(2, "모임"),
    SESSIONS(3, "정규행사");

    private final int code;
    private final String name;

    public static OrgCategory valueOf(Integer dbData) {
        return Arrays.stream(values())
                .filter(category -> category.getCode() == dbData)
                .findFirst().orElse(null);
    }

    public static class CategoryConverter implements AttributeConverter<OrgCategory, Integer> {
        @Override
        public Integer convertToDatabaseColumn(OrgCategory attribute) {
            return attribute.getCode();
        }

        @Override
        public OrgCategory convertToEntityAttribute(Integer dbData) {
            return OrgCategory.valueOf(dbData);
        }
    }
}
