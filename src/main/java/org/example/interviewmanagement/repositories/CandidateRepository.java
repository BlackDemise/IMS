package org.example.interviewmanagement.repositories;

import org.example.interviewmanagement.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
//    List<Candidate> getAllCandidate( );
//        Candidate findByEmail(String email);

}
