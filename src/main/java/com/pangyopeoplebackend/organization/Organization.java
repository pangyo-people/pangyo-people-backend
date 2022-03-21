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
    private String orgId = UUID.randomUUID().toString();

    @Column(nullable = false)
    private String orgName;

    @Column
    @Convert(converter = OrgCategory.CategoryConverter.class)
    private OrgCategory orgCategory;

    @Column
    private String orgDescription;

    @Column
    private String orgUrl;

    @Column
    private boolean orgPermission;

    @Column
    @CreatedDate
    private LocalDateTime orgCreated;


    @PrePersist
    public void prePersist() {
        if (orgId == null) {
            orgId = UUID.randomUUID().toString();
        }
    }
}
