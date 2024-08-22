package org.example.interviewmanagement.services;

import org.example.interviewmanagement.entities.Candidate;
import org.springframework.dao.DataAccessException;

import java.util.Optional;

public interface CandidateService {
    Iterable<Candidate> getAll() throws DataAccessException;
    Optional<Candidate> getById(Long id) throws DataAccessException;

    Candidate save(Candidate candidate);
    void remove(Long id);

//    Candidate getFindEmail(String email);
}
