package org.example.interviewmanagement.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "job_start_date")
    private LocalDate jobStartDate;

    @Column(name = "job_end_date")
    private LocalDate jobEndDate;

    @Column(name = "job_salary_range_from")
    private double jobSalaryRangeFrom;

    @Column(name = "job_salary_range_to")
    private double jobSalaryRangeTo;

    @Column(name = "job_working_address")
    private String jobWorkingAddress;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "job_required_skills")
    private String jobRequiredSkills;

    @Column(name = "job_status")
    private String jobStatus;


//  Job vs MapperLevelJob
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job")
    @ToString.Exclude
    private List<JobLevelMapper> jobLevelMappers;

// Job vs JobBenefitMapper
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job")
    @ToString.Exclude
    private List<JobBenefitMapper> jobBenefitMappers;


// Job vs Interview
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job")
    private List<Interview> interviews;


// Job vs JobCandidateSkill
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job")
    private List<JobSkillMapper> jobSkillMappers;


}
