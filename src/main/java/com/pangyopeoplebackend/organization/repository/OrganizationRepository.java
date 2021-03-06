package com.pangyopeoplebackend.organization.repository;

import com.pangyopeoplebackend.domain.OrgCategory;
import com.pangyopeoplebackend.organization.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, String>{
    List<Organization> findByOrgCategoryAndOrgPermissionOrderByOrgName(OrgCategory orgCategory, boolean orgPermission);

    List<Organization> findAllByOrgPermissionOrderByOrgCreatedAsc(boolean orgPermission);
}
