package com.pangyopeoplebackend.event;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.pangyopeoplebackend.domain.DateToStringConverter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Event {
    @Id
    @Builder.Default
    private String eventId = UUID.randomUUID().toString();

    @Column(nullable = false)
    private String eventName;

    @Column(nullable = false)
    private String host;

    @Column(nullable = false)
    @Convert(converter=DateToStringConverter.class)
    private String startDate;

    @Column(nullable = false)
    @Convert(converter=DateToStringConverter.class)
    private String endDate;

    @Column(nullable = false)
    private String eventUrl;

    @Getter
    @Column(nullable = false)
    private boolean eventPermission;

    @Column(nullable = false)
    private String imageUrl;

    @CreatedDate
    private String eventCreated;

    @PrePersist
    public void prePersist() {
        if (eventId == null) {
            eventId = UUID.randomUUID().toString();
        }
        if (eventCreated == null) {
            this.eventCreated = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
        this.eventCreated = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
