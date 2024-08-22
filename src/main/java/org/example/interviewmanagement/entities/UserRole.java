package org.example.interviewmanagement.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "UserRoles")
public class UserRole {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column (name = "role_name")
    private String roleName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRole")
    @ToString.Exclude
    private List<User> users;


}
