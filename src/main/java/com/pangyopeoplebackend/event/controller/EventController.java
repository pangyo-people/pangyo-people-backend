package com.pangyopeoplebackend.event.controller;

import com.pangyopeoplebackend.event.Event;
import com.pangyopeoplebackend.event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping(path = "/v1/api/events")
    public List<Event> getEvents(){
        return eventService.getEvents();
    }

}
