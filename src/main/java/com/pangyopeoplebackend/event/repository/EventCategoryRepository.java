package com.pangyopeoplebackend.event.repository;

import com.pangyopeoplebackend.event.EventCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventCategoryRepository extends JpaRepository<EventCategory, Integer> {
}
