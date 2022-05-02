package com.pangyopeoplebackend.eventCategory;

import com.pangyopeoplebackend.category.Category;
import com.pangyopeoplebackend.event.Event;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
public class EventCategory{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventCategoryId;

    @ManyToOne()
    @JoinColumn(name = "eventId")
    private Event event;


    @ManyToOne()
    @JoinColumn(name = "categoryId")
    private Category category;

}
