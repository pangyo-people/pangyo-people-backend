package com.pangyopeoplebackend.event.repository;

import com.pangyopeoplebackend.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, String>{
}
