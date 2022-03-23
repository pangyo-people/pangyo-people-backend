package com.pangyopeoplebackend.event.service;

import com.pangyopeoplebackend.event.Event;
import com.pangyopeoplebackend.event.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public List<Event> getEvents() {
        return eventRepository.findAll(Sort.by(Sort.Direction.DESC, "eventDate"));
    }
}
