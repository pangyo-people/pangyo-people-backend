package com.pangyopeoplebackend.organization.repository;

import com.pangyopeoplebackend.organization.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface OrganizationRepository extends JpaRepository<Organization, String>{
}
