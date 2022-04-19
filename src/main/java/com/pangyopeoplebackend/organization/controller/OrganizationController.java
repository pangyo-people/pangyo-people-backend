package com.pangyopeoplebackend.organization.controller;

import com.pangyopeoplebackend.domain.OrgCategory;
import com.pangyopeoplebackend.organization.Organization;
import com.pangyopeoplebackend.organization.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @GetMapping("/v1/api/org/{category}")
    public List<Organization> getOrganizations(@PathVariable("category") OrgCategory orgCategory){
        return organizationService.getOrganizationsByOrgCategory(orgCategory);
    }

    @GetMapping(path = "/v1/api/admin/orgs")
    public List<Organization> getOrganizations(){
        return organizationService.getOrganizations();
    }

    @PutMapping("/v1/api/admin/orgs/{id}")
    public Optional<Organization> updateOrganization(@PathVariable String id){
        return organizationService.updateOrganization(id);
    }
    @DeleteMapping("/v1/api/admin/orgs/{id}")
    public Organization deleteOrganization(@PathVariable String id){
        return organizationService.deleteOrganization(id);
    }

    @PostMapping("/v1/api/org/write")
    public Organization saveOrg(@RequestBody Organization organization) {
        return organizationService.saveOrg(organization);
    }
}