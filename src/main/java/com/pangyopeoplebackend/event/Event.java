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
    private String event_id = UUID.randomUUID().toString();

    @Column(nullable = false)
    private String event_name;

    @Column
    private String event_category;

    @Column
    private String host;

    @Column
    private String event_date;

    @Column
    private String event_url;

    @Column
    private boolean event_permission;

    @Column
    @CreatedDate
    private LocalDateTime event_created;


    @PrePersist
    public void prePersist() {
        if (event_id == null) {
            event_id = UUID.randomUUID().toString();
        }
    }
}
