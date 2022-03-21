package com.pangyopeoplebackend.event;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Event {
    @Id
    private String eventId = UUID.randomUUID().toString();

    @Column(nullable = false)
    private String eventName;

    @Column
    private String eventCategory;

    @Column
    private String host;

    @Column
    private String eventDate;

    @Column
    private String eventUrl;

    @Column
    private boolean eventPermission;

    @Column
    @CreatedDate
    private LocalDateTime eventCreated;

    @PrePersist
    public void prePersist() {
        if (eventId == null) {
            eventId = UUID.randomUUID().toString();
        }
    }
}
