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
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Organization {
    @Id
    private String orgId = UUID.randomUUID().toString();

    @Column(nullable = false)
    private String orgName;

    @Column(nullable = false)
    @Convert(converter = OrgCategory.CategoryConverter.class)
    private OrgCategory orgCategory;

    @Column
    private String orgDescription;

    @Column(nullable = false)
    private String orgUrl;

    @Column(nullable = false)
    private boolean orgPermission;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime orgCreated;

    @PrePersist
    public void prePersist() {
        if (orgId == null) {
            orgId = UUID.randomUUID().toString();
        }
    }
}
