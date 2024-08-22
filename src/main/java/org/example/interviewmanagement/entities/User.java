package org.example.interviewmanagement.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "user_full_name")
    private String userFullName;

    @Column(name = "user_dob")
    private LocalDate userDob;

    @Column(name = "user_phone_number")
    private String userPhoneNumber;

    @Column(name = "user_address")
    private String userAddress;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_gender")
    private String userGender;

    @Column(name = "user_note")
    private String userNote;

    @Column(name = "user_status")
    private String userStatus;

    @Column(name = "user_name")
    private String username;

    @Column(name = "user_password")
    private String userPassword;

    // mapping user role
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "roleId", foreignKey = @ForeignKey(name = "FK_USER_ROLE"))
    private UserRole userRole;

    // mapping user offer department
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "departmentId", foreignKey = @ForeignKey(name = "FK_USER_OFFER_DEPARTMENT"))
    private UserOfferDepartment userOfferDepartment;

    //mapping interview mapper
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @ToString.Exclude
    private List<InterviewMapper> interviewMappers;

    // mapping candidate recuiter
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Candidate> candidates;

    // mapping candidate owner
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private List<Candidate> candidate;

    // mapping  offerRecruiter
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recruiter")
    private List<Offer> offer;

    // mapping offer approver
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "approver")
    private List<Offer> offers;

    // mapping interview
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Interview> interviews;
}
