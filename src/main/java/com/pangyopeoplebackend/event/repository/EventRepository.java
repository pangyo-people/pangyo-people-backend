package com.pangyopeoplebackend.event.repository;

import com.pangyopeoplebackend.domain.EventCategory;
import com.pangyopeoplebackend.event.Event;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, String>{
    List<Event> findByEventCategoryOrderByEventDateDesc(EventCategory eventCategory);
}
