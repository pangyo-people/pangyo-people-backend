package com.pangyopeoplebackend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.AttributeConverter;
import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum EventCategory {
    AI(0, "AI"),
    ANDROID(1, "Android"),
    iOS(2, "iOS"),
    CONTEST(3, "경진대회"),
    EDUCATION(4, "교육"),
    BIGDATA(5, "빅데이터"),
    CLUB(6, "동아리"),
    MENTORING(7, "멘토링"),
    SECURITY(8, "보안"),
    CONFERENCE(9, "컨퍼런스"),
    CLOUD(10, "클라우드"),
    PROJECT(11, "프로젝트");

    private final int code;
    private final String name;

    public static EventCategory valueOf(Integer dbData) {
        return Arrays.stream(values())
                .filter(category -> category.getCode() == dbData)
                .findFirst().orElse(null);
    }

    public static class CategoryConverter implements AttributeConverter<EventCategory, Integer> {
        @Override
        public Integer convertToDatabaseColumn(EventCategory attribute) {
            return attribute.getCode();
        }

        @Override
        public EventCategory convertToEntityAttribute(Integer dbData) {
            return EventCategory.valueOf(dbData);
        }
    }
}
