package com.pangyopeoplebackend.eventCategory.repository;

import com.pangyopeoplebackend.eventCategory.EventCategory;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventCategoryRepository extends JpaRepository<EventCategory, Integer>{
    @Override
    @EntityGraph(attributePaths = {"event"}) // (2)
    List<EventCategory> findAll();

    @Query("select ec.category.categoryId from EventCategory ec where ec.event.eventId = :eventId")
    List<Integer> selectCategoryIdByEventId(@Param(value = "eventId") String eventId);
    //select category_id from pgppdev.event_category WHERE event_id = 'e54aca9c-f38f-48e6-9ad4-bff0dca04e98';

    @Query("select ec from EventCategory ec where ec.event.eventId = :eventId")
    List<EventCategory> selectByEventId(@Param(value = "eventId") String eventId);

    EventCategory findByEventCategoryId(Long eventCategoryId);

}
