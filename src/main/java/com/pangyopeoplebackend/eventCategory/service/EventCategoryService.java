package com.pangyopeoplebackend.eventCategory.service;

import com.pangyopeoplebackend.category.Category;
import com.pangyopeoplebackend.category.repository.CategoryRepository;
import com.pangyopeoplebackend.event.Event;
import com.pangyopeoplebackend.event.dto.EventDto;
import com.pangyopeoplebackend.event.repository.EventRepository;
import com.pangyopeoplebackend.event.service.EventService;
import com.pangyopeoplebackend.eventCategory.EventCategory;
import com.pangyopeoplebackend.eventCategory.repository.EventCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventCategoryService {
    private final EventRepository eventRepository;
    private final CategoryRepository categoryRepository;
    private final EventCategoryRepository eventCategoryRepository;
    private final EventService eventService;

    @Transactional
    public EventCategory save(Event event, Category category) {
        event = eventRepository.save(event);
        if (!categoryRepository.existsById(category.getCategoryId())){
            category = categoryRepository.save(category);
        }

        return eventCategoryRepository.save(EventCategory.builder()
                .event(event)
                .category(category).build());
    }

    public List<EventCategory> getEventCategories() {
        return eventCategoryRepository.findAll();
    }

    public List<Integer> getCategoryIdsByEventId(String id) {
        return eventCategoryRepository.selectCategoryIdByEventId(id);
    }

    public EventDto getEventDtoFromEvent(Event event) {

        return new EventDto(event.getEventId(), event.getEventName(),
                event.getHost(), event.getStartDate(),
                event.getEndDate(), event.getEventUrl(),
                event.getImageUrl(), event.isEventPermission(),
                event.getEventCreated(), getCategoryIdsByEventId(event.getEventId()));
    }

    public List<EventDto> getEventDto(){
        ArrayList<EventDto> events = new ArrayList<>();
        for(Event event : eventService.getEvents()){
            if (event.isEventPermission()) {
                events.add(getEventDtoFromEvent(event));
            }
        }

        return events.stream().sorted(Comparator.comparing(EventDto::getEndDate)).toList();
    }

    public EventCategory getEventCategoryByEventCategoryId(Long eventCategoryId) {
        return eventCategoryRepository.findByEventCategoryId(eventCategoryId);
    }

    @Transactional
    public Event deleteEvent(String id){
        Optional<Event> deleteEvent = eventRepository.findById(id);
        List<EventCategory> deleteEventCategory = eventCategoryRepository.selectByEventId(id);

        deleteEventCategory.removeIf(selectEventCategory -> {
            eventCategoryRepository.delete(selectEventCategory);
            return true;
        });

        deleteEvent.ifPresent(selectEvent->{
            eventRepository.delete(selectEvent);
        });

        return deleteEvent.get();
    }

    @Transactional
    public Event saveEventDto(EventDto eventDto) {

        Event event = Event.builder()
                .eventName(eventDto.getEventName())
                .host(eventDto.getHost())
                .eventUrl(eventDto.getEventUrl())
                .imageUrl(eventDto.getImageUrl())
                .startDate(eventDto.getStartDate())
                .endDate(eventDto.getEndDate())
                .eventPermission(false)
                .build();
        eventRepository.save(event);

        for(Integer categoryId: eventDto.getCategories()){
            eventCategoryRepository.save(EventCategory.builder()
                    .event(eventRepository.getById(event.getEventId()))
                    .category(categoryRepository.getById(categoryId))
                    .build());
        }

        return event;
    }

}
