package com.pangyopeoplebackend.event.repository;

import com.pangyopeoplebackend.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventRepository extends JpaRepository<Event, String>{

}
