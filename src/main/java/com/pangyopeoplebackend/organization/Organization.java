package com.pangyopeoplebackend.organization;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class Organization {
    @Id
    private String org_id;

    @Column(nullable = false)
    private String org_name;

    @Column
    private String org_category;

    //@Column
    //@Convert(converter = Category.CategoryConverter.class // enum으로 수정 필요
    //private Category category;

    @Column
    private String org_description;

    @Column
    private String org_url;

    @Column
    private boolean org_permission;

    @Column
    private String org_created; // 만든 날짜로 수정


    @PrePersist
    public void prePersist() {
        if (org_id == null) {
            org_id = UUID.randomUUID().toString();
        }
    }
}
