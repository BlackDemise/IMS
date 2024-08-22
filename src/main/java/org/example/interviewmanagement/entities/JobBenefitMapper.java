package org.example.interviewmanagement.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "JobBenefitMapper")
public class JobBenefitMapper {
    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id", foreignKey = @ForeignKey(name = "FK_JOB_BENEFIT"))
    private Job job;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "benefit_id", foreignKey = @ForeignKey(name = "FK_JOB_BENEFIT_LEVEL"))
    private JobBenefit jobBenefit;
}
