package org.example.interviewmanagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "JobCandidateSkills")
public class JobCandidateSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillId;

    @Column(name = "skill_name")
    private String skillName;

// Job Skill Mapper vs Job Candidate Skill
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobCandidateSkill")
    private List<JobSkillMapper> jobSkillMappers;

// job candidate skill vs candidate skill mapper
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobCandidateSkill")
    private List<CandidateSkillMapper> candidateSkillMappers;
}
