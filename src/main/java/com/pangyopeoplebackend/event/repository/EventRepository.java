package com.pangyopeoplebackend.event.repository;

import com.pangyopeoplebackend.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, String>{
}
