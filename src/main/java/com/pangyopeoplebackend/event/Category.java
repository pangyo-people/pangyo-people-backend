package com.pangyopeoplebackend.event;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Category {
    @Id
    private int categoryId;

    @Column(nullable = false)
    private String categoryName;
}
