package com.pangyopeoplebackend.organization.repository;

import com.pangyopeoplebackend.domain.OrgCategory;
import com.pangyopeoplebackend.organization.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface OrganizationRepository extends JpaRepository<Organization, String>{

    List<Organization> findByOrgCategoryOrderByOrgName(OrgCategory orgCategory);
}
