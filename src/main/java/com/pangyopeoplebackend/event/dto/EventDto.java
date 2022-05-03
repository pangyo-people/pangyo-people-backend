package com.pangyopeoplebackend.event.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class EventDto {
    private String eventId;
    private String eventName;
    private String host;
    private String startDate;
    private String endDate;
    private String eventUrl;
    private String imageUrl;
    private boolean eventPermission;
    private String eventCreated;
    private List<Integer> categories;
}