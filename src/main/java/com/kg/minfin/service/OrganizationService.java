package com.kg.minfin.service;


import com.kg.minfin.entity.Organization;
import com.kg.minfin.exception.OrganizationNotFoundException;
import com.kg.minfin.repository.OrganizationRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class OrganizationService {
    OrganizationRepository organizationRepository;

    public ResponseEntity<Organization> fetchOrganizationById(Long id)  {
        return ResponseEntity.ok(organizationRepository.findById(id).orElseThrow(() -> new OrganizationNotFoundException("Organization  with id %d has not been found".formatted(id))));
    }

    public ResponseEntity<List<Organization>> fetchAllOrganizations() {
        return ResponseEntity.ok(organizationRepository.findAll());
    }

    public ResponseEntity<String> saveOrganization(Organization organization) {
        organizationRepository.save(organization);
        return ResponseEntity.ok("Organization has been saved");
    }

    public ResponseEntity<String> deleteOrganization(Long id) {
        organizationRepository.deleteById(id);
        return ResponseEntity.ok("Organization has been removed");
    }

}
