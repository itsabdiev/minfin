package com.kg.minfin.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee extends BaseEntity{

    @Column(name = "email",nullable = false)
    String email;

    @Column(name = "home_phone")
    @JsonProperty("home_phone")
    String homePhone;

    @Column(name = "mobile_phone")
    @JsonProperty("mobile_phone")
    String mobilePhone;

    @Column(name = "work_phone")
    @JsonProperty("work_phone")
    String workPhone;

    @Column(name = "home_address")
    @JsonProperty("home_address")
    String homeAddress;

    @Column(name = "web_page")
    @JsonProperty("web_page")
    String webPage;

    @Column(name = "bank_details")
    @JsonProperty("bank_details")
    @ElementCollection(targetClass=String.class, fetch = FetchType.EAGER)
    List<String> bankDetails = new ArrayList<>();

    @Column(name = "job_title")
    @JsonProperty("job_title")
    String jobTitle;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
