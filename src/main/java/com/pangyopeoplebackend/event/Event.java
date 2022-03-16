package com.pangyopeoplebackend.event;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class Event {
    @Id
    private String event_id;

    @Column(nullable = false)
    private String event_name;

    @Column
    private String event_category;

    //@Column
    //@Convert(converter = Category.CategoryConverter.class // enum으로 수정 필요
    //private Category category;

    @Column
    private String host;

    @Column
    private String event_date;

    @Column
    private String event_url;

    @Column
    private boolean event_permission;

    @Column
    private String event_created; // 만든 날짜로 수정


    @PrePersist
    public void prePersist() {
        if (event_id == null) {
            event_id = UUID.randomUUID().toString();
        }
    }
}
