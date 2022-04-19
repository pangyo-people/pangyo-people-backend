package com.pangyopeoplebackend.organization.service;

import com.pangyopeoplebackend.domain.OrgCategory;
import com.pangyopeoplebackend.organization.Organization;
import com.pangyopeoplebackend.organization.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    @Transactional
    public Organization saveOrg(Organization organization) {
        return organizationRepository.save(organization);
    }

    @Transactional
    public Optional<Organization> updateOrganization(String id) {
        Optional<Organization> updateOrganization = organizationRepository.findById(id);

        updateOrganization.ifPresent(selectOrganization->{
            selectOrganization.setOrgPermission(true);
            organizationRepository.save(selectOrganization);
        });
        return updateOrganization;
    }

    @Transactional
    public Organization deleteOrganization(String id){
        Optional<Organization> updateOrganization = organizationRepository.findById(id);
        updateOrganization.ifPresent(selectOrganization->{
            organizationRepository.delete(selectOrganization);
        });
        return updateOrganization.get();
    }
}