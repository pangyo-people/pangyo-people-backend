package com.pangyopeoplebackend.event.controller;

import com.pangyopeoplebackend.event.Event;
import com.pangyopeoplebackend.event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping(path = "/v1/api/events")
    public List<Event> getEvents(){
        return eventService.getEvents();
    }

    @PostMapping("/v1/api/events/write")
    public Event saveOrg(@RequestBody Event event) {
        return eventService.saveEvent(event);
    }
}
