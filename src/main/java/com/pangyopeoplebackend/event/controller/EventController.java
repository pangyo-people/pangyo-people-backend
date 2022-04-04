package com.pangyopeoplebackend.event.controller;

import com.pangyopeoplebackend.domain.EventCategory;
import com.pangyopeoplebackend.domain.OrgCategory;
import com.pangyopeoplebackend.event.Event;
import com.pangyopeoplebackend.event.service.EventService;
import com.pangyopeoplebackend.organization.Organization;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping(path = "/v1/api/events")
    public List<Event> getEvents(){
        return eventService.getEvents();
    }

    @GetMapping("/v1/api/events/category/{number}")
    public List<Event> getEventsByCategory(@PathVariable int number) {
        return eventService.getEventsByCategory(number);
    }

    @PostMapping("/v1/api/events/write")
    public Event saveOrg(@RequestBody Event event) {
        return eventService.saveEvent(event);
    }
}
