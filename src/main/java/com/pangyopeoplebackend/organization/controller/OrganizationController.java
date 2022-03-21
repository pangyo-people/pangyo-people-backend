package com.pangyopeoplebackend.organization.controller;

import com.pangyopeoplebackend.domain.OrgCategory;
import com.pangyopeoplebackend.event.Event;
import com.pangyopeoplebackend.event.service.EventService;
import com.pangyopeoplebackend.organization.Organization;
import com.pangyopeoplebackend.organization.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    //@GetMapping(path = "/v1/api/org/")
    //public List<Organization> getOrganizations(){
    //    return organizationService.getOrganizations();
    //}

    @GetMapping("/v1/api/org/{category}")
    public List<Organization> getOrganizations(@PathVariable("category") OrgCategory orgCategory){
        return organizationService.getOrganizationsByOrgCategory(orgCategory);
    }
}