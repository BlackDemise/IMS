package org.example.interviewmanagement.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "UserOfferDepartments")
public class UserOfferDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    @Column(name = "department_name")
    private String departmentName;

//   UserOfferDepartment vs user
    @OneToMany(mappedBy = "userOfferDepartment", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<User> users;

// UserOfferDepartment vs offer
    @OneToMany(mappedBy = "userOfferDepartment", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Offer> offers;
}
