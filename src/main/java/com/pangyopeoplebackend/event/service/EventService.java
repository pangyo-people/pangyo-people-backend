package com.pangyopeoplebackend.event.service;

import com.pangyopeoplebackend.event.Event;
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

    public List<Event> getEvents() {
        return eventRepository.findAll(Sort.by( "endDate"));
    }

    @Transactional
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }
}
