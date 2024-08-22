package org.example.interviewmanagement.repositories;

import lombok.Data;
import org.example.interviewmanagement.entities.Candidate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class CandidateRepositoryTest {

    @Autowired
    private CandidateRepository candidateRepository;

    @Test
    void saveMethod(){
        // create candidate
        Candidate candidate = new Candidate();
        candidate.setCandidateId(4L);
        candidate.setCandidateDob(LocalDate.parse("2014-12-12"));
        candidate.setCandidateEmail("SuperThang@gmail.com");
        candidate.setCandidateFullName("Phuong");
        candidate.setCandidatePhonenumber("0788077563");
        candidate.setCandidateNote("BA");
        candidate.setCandidateStatus("Open");

        // save candidate
         Candidate saveCandidate1 = candidateRepository.save(candidate);
        // display candidate
        System.out.println(saveCandidate1.getCandidateId());
        System.out.println(saveCandidate1.toString());
    }

    @Test
    void findByIdMethod(){
        Long id = 1L;
        Candidate candidate = candidateRepository.findById(id).get();

    }
//    @Test
//    void deleteByIdMethod(){
//        Long id = 1L;
//        Candidate candidate = candidateRepository.deleteById(id);
//    }


}