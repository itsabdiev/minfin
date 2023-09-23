package com.kg.minfin.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "organizations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Organization extends BaseEntity {


    @Column(name = "form_of_ownership",nullable = false)
    @JsonProperty("form_of_ownership")
    String formOfOwnership;

    @Column(name = "legal_form",nullable = false)
    @JsonProperty("legal_form")
    String legalForm;


    @Column(nullable = false)
    String name;

    @Column(name = "supervisor_name")
    @JsonProperty("supervisor_name")
    String supervisorName;

    @Column(nullable = false)
    String fax;

    @Column(name = "phone_number")
    @JsonProperty("phone_number")
    String phoneNumber;

    @Column(name = "web_page")
    @JsonProperty("web_page")
    String webPage;

    @Column(nullable = false)
    String login;

    @Column(name = "license_number",nullable = false)
    @JsonProperty("license_number")
    String licenseNumber;

    @Column(name = "license_receipt_date",nullable = false)
    @JsonProperty("license_receipt_date")
    LocalDate licenseReceiptDate;

    @Column(name = "certificate_number",nullable = false)
    @JsonProperty("certificate_number")
    String certificateNumber;

    @Column(name = "certificate_receipt_date",nullable = false)
    @JsonProperty("certificate_receipt_date")
    LocalDate certificateReceiptDate;

    @Column(nullable = false)
    String address;


    @Column(name = "file_paths")
    @JsonProperty("file_paths")
    @ElementCollection(targetClass=String.class, fetch = FetchType.EAGER)
    List<String> filePaths = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, targetEntity = Employee.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    List<Employee> employees = new ArrayList<>();





















    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization organization = (Organization) o;
        return Objects.equals(id, organization.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
