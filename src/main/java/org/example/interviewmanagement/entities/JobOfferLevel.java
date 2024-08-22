package org.example.interviewmanagement.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "JobOfferLevels")
public class JobOfferLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long levelId;

    @Column(name = "level_title")
    private String levelTitle;

    //  Level vs MapperLevelJob
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobOfferLevel")
    @ToString.Exclude
    private List<JobLevelMapper> jobLevelMappers;

    // offer vs level
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobOfferLevel")
    @ToString.Exclude
    private List<Offer> offers;
}
