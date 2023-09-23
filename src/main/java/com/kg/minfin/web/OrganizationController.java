package com.kg.minfin.web;


import com.kg.minfin.entity.Organization;
import com.kg.minfin.service.OrganizationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/organizations")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class OrganizationController {
    OrganizationService organizationService;

    @GetMapping("{id}")
    public ResponseEntity<Organization> getOrganization(@PathVariable("id") Long id) {
        return organizationService.fetchOrganizationById(id);
    }

    @GetMapping
    public ResponseEntity<List<Organization>> getAllOrganizations() {
        return organizationService.fetchAllOrganizations();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> removeOrganizationById(@PathVariable("id") Long id) {
        return organizationService.deleteOrganization(id);
    }

    @PostMapping
    public ResponseEntity<String> saveOrganization(@RequestBody Organization organization) {
        return organizationService.saveOrganization(organization);
    }

}
