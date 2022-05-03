package com.pangyopeoplebackend.eventCategory.controller;

import com.pangyopeoplebackend.event.dto.EventDto;
import com.pangyopeoplebackend.eventCategory.service.EventCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventCategoryController {

    private final EventCategoryService eventCategoryService;

   @GetMapping(path = "/v1/api/events")
    public List<EventDto> getEvents(){
        return eventCategoryService.getEventDto();
    }

    /* @PostMapping("/v1/api/events/write")
    public Event saveOrg(@RequestBody Event event) {
        return eventService.saveEvent(event);
    }*/
}