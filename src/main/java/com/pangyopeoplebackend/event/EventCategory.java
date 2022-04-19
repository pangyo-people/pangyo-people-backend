package com.pangyopeoplebackend.event;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class EventCategory{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long EventCategoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventId")
    private Event eventId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private Category categoryId;

    @Builder
    public EventCategory(Event event, Category category){
        this.eventId = event;
        this.categoryId = category;
    }
}
