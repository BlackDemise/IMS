package org.example.interviewmanagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.interviewmanagement.enums.EPosition;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offerId;

    @Column(name = "offer_contract_period_from")
    private LocalDate offerContractPeriodFrom;

    @Column(name = "offer_contract_period_to")
    private LocalDate offerContractPeriodTo;

    @Column(name = "offer_note")
    private String offerNote;

    @Column(name = "offer_basic_salary")
    private BigDecimal offerBasicSalary;

    @Column(name = "offer_due_date")
    private LocalDate offerDueDate;

    @Column(name = "offer_contract")
    private String offerContract;
    // offer recruiter vs user
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "offer_recruiter_id", foreignKey = @ForeignKey(name = "FK_Offer_User_Recruiter"))
    private User recruiter;
    // offer approver vs user
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "offer_approver_id", foreignKey = @ForeignKey(name = "FK_Offer_User_APPROVER"))
    private User approver;
    // offer vs candidate offer position
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn( name = "offer_position_id", foreignKey = @ForeignKey(name = "FK_Offer_Position"))
//    private CandidatePosition candidatePosition;
    @Column(name = "offer_candidate_position")
    private String candidatePosition;

    //    @Enumerated(EnumType.STRING)
//    @Column(name = "position")
//    private EPosition offerPosition;
// offer vs candidate
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "offer_candidate_id", foreignKey = @ForeignKey(name = "FK_Offer_Candidate"))
    private Candidate candidate;

    // offer vs UserOfferDepartment
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "offer_department_id", foreignKey = @ForeignKey(name = "FK_Offer_DEPARTMENT"))
//    private UserOfferDepartment userOfferDepartment;

    @Column(name = "offer_department")
    private String userOfferDepartment;
    // offer vs interview
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "offer_interview_info", foreignKey = @ForeignKey(name = "FK_Offer_INTERVIEW"))
    private Interview interview;

    // offer vs  jobOfferLevel
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "offer_level_id", foreignKey = @ForeignKey(name = "FK_Offer_LEVEL"))
//    private JobOfferLevel jobOfferLevel;
    @Column(name = "offer_level")
    private String jobOfferLevel;
}
