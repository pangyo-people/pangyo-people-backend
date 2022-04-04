package com.pangyopeoplebackend.event.service;

import com.pangyopeoplebackend.domain.EventCategory;
import com.pangyopeoplebackend.event.Event;
import com.pangyopeoplebackend.event.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public List<Event> getEvents() {
        return eventRepository.findAll(Sort.by(Sort.Direction.DESC, "eventDate"));
    }

    public List<Event> getEventsByCategory(int eventCategory) {
        return eventRepository.findByEventCategoryOrderByEventDateDesc(eventCategory);
    }

    @Transactional
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }
}
