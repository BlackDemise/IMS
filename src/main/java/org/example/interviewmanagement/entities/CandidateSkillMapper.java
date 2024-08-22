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
@Table(name = "CandidateSkillMapper")
public class CandidateSkillMapper {
    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "candidate_id", foreignKey = @ForeignKey(name = "FK_CANDIDATES_SKILL"))
    private Candidate candidate;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "skill_id", foreignKey = @ForeignKey(name = "FK_JOBS_CANDIDATES_SKILL"))
    private JobCandidateSkill jobCandidateSkill;
}
