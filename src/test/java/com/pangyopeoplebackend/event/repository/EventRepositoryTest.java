package com.pangyopeoplebackend.event.repository;

import com.pangyopeoplebackend.event.Event;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EventRepositoryTest {
    @Autowired
    EventRepository eventRepository;

    @Test
    @Rollback(value = false)
    void saveTest() throws Throwable{

        Event event = Event.builder()
                .eventName("name")
                .eventCategory("category")
                .host("host")
                .eventDate("date")
                .eventUrl("url")
                .eventPermission(true)
                .build();

        event = eventRepository.save(event);

        assertNotNull(event.getEventId());

    }
}
