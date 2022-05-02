package com.pangyopeoplebackend.eventCategory.repository;

import com.pangyopeoplebackend.eventCategory.EventCategory;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventCategoryRepository extends JpaRepository<EventCategory, Integer> {
    @Override
    @EntityGraph(attributePaths = {"event"}) // (2)
    List<EventCategory> findAll();

    List<EventCategory> findCategoryByEvent(String eventId);

}
