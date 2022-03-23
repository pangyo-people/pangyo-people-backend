package com.pangyopeoplebackend.organization.service;

import com.pangyopeoplebackend.domain.OrgCategory;
import com.pangyopeoplebackend.organization.Organization;
import com.pangyopeoplebackend.organization.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationService {
    private final OrganizationRepository organizationRepository;

    public List<Organization> getOrganizations() {
        return organizationRepository.findAll();
    }

    public List<Organization> getOrganizationsByOrgCategory(OrgCategory orgCategory) {
        return organizationRepository.findByOrgCategoryOrderByOrgName(orgCategory);
    }
}