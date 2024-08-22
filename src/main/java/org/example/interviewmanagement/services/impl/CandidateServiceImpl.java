package org.example.interviewmanagement.services.impl;

import org.example.interviewmanagement.entities.Candidate;
import org.example.interviewmanagement.repositories.CandidateRepository;
import org.example.interviewmanagement.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {
    private CandidateRepository candidateRepository;
    @Autowired
    public CandidateServiceImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public Iterable<Candidate> getAll() throws DataAccessException {
        return candidateRepository.findAll();
    }

    @Override
    public Optional<Candidate> getById(Long id) throws DataAccessException {
        return candidateRepository.findById(id);
    }

    @Override
    public Candidate save(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public void remove(Long id) {
        candidateRepository.deleteById(id);
    }

//    @Override
//    public Candidate getFindEmail(String email) {
//        return candidateRepository.findByEmail(email);
//    }


}
