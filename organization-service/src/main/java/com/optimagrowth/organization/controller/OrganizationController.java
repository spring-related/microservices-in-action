package com.optimagrowth.organization.controller;

import com.optimagrowth.organization.model.Organization;
import com.optimagrowth.organization.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping(value="v1/organization")
public class OrganizationController {
    private final OrganizationService service;

    public OrganizationController(OrganizationService service) {
        this.service = service;
    }


    @GetMapping(value="/{organizationId}")
    @RolesAllowed({ "ADMIN", "USER" })
    public ResponseEntity<Organization> getOrganization(@PathVariable("organizationId") String organizationId) {
        return ResponseEntity.ok(service.findById(organizationId));
    }

    @PutMapping(value="/{organizationId}")
    @RolesAllowed({ "ADMIN", "USER" })
    public void updateOrganization( @PathVariable("organizationId") String id, @RequestBody Organization organization) {
        service.update(organization);
    }

    @PostMapping
    @RolesAllowed({ "ADMIN", "USER" })
    public ResponseEntity<Organization>  saveOrganization(@RequestBody Organization organization) {
        return ResponseEntity.ok(service.create(organization));
    }

//    @DeleteMapping(value="/{organizationId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @RolesAllowed("ADMIN")
//    public void deleteOrganization( @PathVariable("organizationId") String id,  @RequestBody Organization organization) {
//        service.delete(organization);
//    }
    @DeleteMapping(value="/{organizationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RolesAllowed("ADMIN")
    public void deleteOrganizationById( @PathVariable("organizationId") String id) {
        service.deleteById(id);
    }

}
