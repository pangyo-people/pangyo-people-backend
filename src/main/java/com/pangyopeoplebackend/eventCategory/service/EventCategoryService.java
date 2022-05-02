package com.pangyopeoplebackend.eventCategory.service;

import com.pangyopeoplebackend.category.Category;
import com.pangyopeoplebackend.category.repository.CategoryRepository;
import com.pangyopeoplebackend.event.Event;
import com.pangyopeoplebackend.event.repository.EventRepository;
import com.pangyopeoplebackend.eventCategory.EventCategory;
import com.pangyopeoplebackend.eventCategory.repository.EventCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventCategoryService {
    private final EventRepository eventRepository;
    private final CategoryRepository categoryRepository;
    private final EventCategoryRepository eventCategoryRepository;

    @Transactional
    public EventCategory save(Event event, Category category) {
        event = eventRepository.save(event);
        if (!categoryRepository.existsById(category.getCategoryId())){
            category = categoryRepository.save(category);
        }

        return eventCategoryRepository.save(EventCategory.builder()
                .event(event)
                .category(category).build());
    }

    public List<EventCategory> getEventCategories() {
        return eventCategoryRepository.findAll();
    }

    public List<EventCategory> getEventCategoriesByEventId(String id) {
        return eventCategoryRepository.findCategoryByEvent(id);
    }

}
