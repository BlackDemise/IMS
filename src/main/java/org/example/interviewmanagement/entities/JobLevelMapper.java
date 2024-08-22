package org.example.interviewmanagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "JobLevelMappers")
public class JobLevelMapper {
    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id", foreignKey = @ForeignKey(name = "FK_JOB_LEVEL"))
    private Job job;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "level_id", foreignKey = @ForeignKey(name = "FK_JOB_OFFER_LEVEL"))
    private JobOfferLevel jobOfferLevel;
}
