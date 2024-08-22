package org.example.interviewmanagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "JobSkillMapper")
public class JobSkillMapper {
    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id", foreignKey = @ForeignKey(name = "FK_JOB_SKILL"))
    private Job job;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "skill_id", foreignKey = @ForeignKey(name = "FK_CANDIDATE_SKILL"))
    private JobCandidateSkill jobCandidateSkill;
}
