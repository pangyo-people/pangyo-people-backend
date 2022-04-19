package com.pangyopeoplebackend.event.service;

import com.pangyopeoplebackend.event.Category;
import com.pangyopeoplebackend.event.Event;
import com.pangyopeoplebackend.event.EventCategory;
import com.pangyopeoplebackend.event.repository.CategoryRepository;
import com.pangyopeoplebackend.event.repository.EventCategoryRepository;
import com.pangyopeoplebackend.event.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final CategoryRepository categoryRepository;
    private final EventCategoryRepository eventCategoryRepository;

    public void EventCategory(String eventId, int categoryId){
        Event event = eventRepository.findById(eventId).get();
        Category category = categoryRepository.findById(categoryId).get();
        eventCategoryRepository.save(EventCategory.builder()
                        .event(event)
                        .category(category).build());

    }

    public List<Event> getEvents() {
        return eventRepository.findAll(Sort.by(Sort.Direction.DESC, "eventDate"));
    }

    @Transactional
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }
}
