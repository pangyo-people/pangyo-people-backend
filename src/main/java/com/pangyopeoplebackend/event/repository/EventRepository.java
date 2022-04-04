package com.pangyopeoplebackend.event.repository;

import com.pangyopeoplebackend.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, String>{
    List<Event> findByEventCategoryOrderByEventDateDesc(int eventCategory);
}
