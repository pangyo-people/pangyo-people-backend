package com.pangyopeoplebackend.organization;

import com.pangyopeoplebackend.domain.OrgCategory;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Organization {
    @Id
    private String org_id = UUID.randomUUID().toString();

    @Column(nullable = false)
    private String org_name;

    @Column
    @Convert(converter = OrgCategory.CategoryConverter.class)
    private OrgCategory org_category;

    @Column
    private String org_description;

    @Column
    private String org_url;

    @Column
    private boolean org_permission;

    @Column
    @CreatedDate
    private LocalDateTime org_created;


    @PrePersist
    public void prePersist() {
        if (org_id == null) {
            org_id = UUID.randomUUID().toString();
        }
    }
}
