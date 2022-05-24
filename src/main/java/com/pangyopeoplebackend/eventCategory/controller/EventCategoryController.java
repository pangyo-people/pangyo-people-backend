package com.pangyopeoplebackend.eventCategory.controller;

import com.pangyopeoplebackend.category.service.CategoryService;
import com.pangyopeoplebackend.event.Event;
import com.pangyopeoplebackend.event.dto.EventDto;
import com.pangyopeoplebackend.event.service.EventService;
import com.pangyopeoplebackend.eventCategory.service.EventCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventCategoryController {

    private final EventCategoryService eventCategoryService;
    private final CategoryService categoryService;
    private final EventService eventService;

    @GetMapping(path = "/v1/api/events")
    public List<EventDto> getEvents() throws Throwable {
        categoryService.save();
        return eventCategoryService.getEventDto();
    }

    @PostMapping("/v1/api/event/write")
    public Event saveEvent(@RequestBody EventDto eventDto) {
        return eventCategoryService.saveEventDto(eventDto);
    }

    @DeleteMapping("/v1/api/admin/event/{id}")
    public Event deleteEvent(@PathVariable String id){
        return eventCategoryService.deleteEvent(id);
    }

    @PutMapping(path = "/v1/api/admin/event/{id}")
    public boolean permitEvent(@PathVariable String id){
        return eventService.permitEvent(id);
    }

    @GetMapping(path = "/v1/api/admin/events")
    public List<EventDto> getAdminEvents(){
        return eventCategoryService.getAdminEventDto();
    }
}