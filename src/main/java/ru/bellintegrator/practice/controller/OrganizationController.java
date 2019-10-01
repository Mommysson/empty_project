package ru.bellintegrator.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.service.OrganizationServiceImpl;


import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;



@RestController
@RequestMapping(value = "api/organization", produces=APPLICATION_JSON_VALUE)
public class OrganizationController {
@Autowired
OrganizationServiceImpl organizationServiceImpl;

    public OrganizationController(OrganizationServiceImpl organizationServiceImpl) {
        this.organizationServiceImpl = organizationServiceImpl;
    }

    @PostMapping(value ="/list")
    public List<Organization> getOrganizations (@RequestParam String name, @RequestParam Long inn, @RequestParam boolean isActive) {
        return organizationServiceImpl.getOrganizations(name, inn, isActive);

    }
    @GetMapping(value ="/{id}")
    public Organization getOrganization (@PathVariable Long id) {
        return organizationServiceImpl.getOrganization(id);

    }
    @PostMapping(value ="/update")
    @ResponseBody
    public String updateOrganization (@RequestParam Long id, @RequestParam String name, @RequestParam String full_Name,
                                    @RequestParam Long inn,@RequestParam Long kpp,@RequestParam String address,
                                    @RequestParam Long phone,@RequestParam boolean is_Active) {
        Organization organization = new Organization();
        organization.setId(id);
        organization.setName(name);
        organization.setFullName(full_Name);
        organization.setInn(inn);
        organization.setKpp(kpp);
        organization.setAddress(address);
        organization.setPhone(phone);
        organization.setActive(is_Active);

        organizationServiceImpl.updateOrganization(organization);
return "“result”:”success”";
    }

}
