package org.example.interviewmanagement.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CandidatePositions")
public class CandidatePosition  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long positionId;
    @Column
    private String positionTitle;
// candidate offer positions vs candidate
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidatePosition")
    private List<Candidate> candidates;

// candidateOfferPosition  vs Offer
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidatePosition")
    private List<Offer> offers;

}
