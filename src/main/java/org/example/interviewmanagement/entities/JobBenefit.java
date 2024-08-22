package org.example.interviewmanagement.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "JobBenefits")
public class JobBenefit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long benefitId;

    @Column(name = "benefit_title")
    private String benefitTitle;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobBenefit")
    @ToString.Exclude
    private List<JobBenefitMapper> jobBenefitMappers;
}
