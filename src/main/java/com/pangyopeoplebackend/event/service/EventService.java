package com.pangyopeoplebackend.event.service;

import com.pangyopeoplebackend.event.Event;
import com.pangyopeoplebackend.event.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    @Autowired
    private final EventRepository eventRepository;

    public List<Event> getEvents() {
        return eventRepository.findAll(Sort.by( "endDate"));
    }

    public Event getEvent(String eventId){
        return eventRepository.getById(eventId);
    }

    @Transactional
    public boolean permitEvent(String eventId){
        getEvent(eventId).setEventPermission(true);
        return true;
    }

    @Transactional
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }
}
