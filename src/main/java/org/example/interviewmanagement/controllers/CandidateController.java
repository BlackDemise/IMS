package org.example.interviewmanagement.controllers;

import org.example.interviewmanagement.entities.Candidate;
import org.example.interviewmanagement.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/candidate")
public class CandidateController {
    private CandidateService candidateService;
    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    // find all
    @GetMapping("/")
    public String viewCandidate(Model model){
        model.addAttribute("candidateList", candidateService.getAll());
        return "candidateview";
    }

    // find by id
    @GetMapping
    public ResponseEntity<Candidate> getCandidateById(@PathVariable Long id){
        Optional<Candidate> candidateOptional = candidateService.getById(id);
        return candidateOptional.map(candidate -> new ResponseEntity<>(candidate, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


//    @GetMapping("/")
//    public String findByEmail(Model model, String email){
//        model.addAttribute("candidateList", candidateService.getFindEmail(email));
//        return "candidateview";
//    }
    //update by id
    @PutMapping("/add")
    public ResponseEntity<Candidate> updateCategory(@PathVariable Long id, @RequestBody Candidate candidate) {
        Optional<Candidate> categoryOptional = candidateService.getById(id);
        return categoryOptional.map(category1 -> {
            candidate.setCandidateId(category1.getCandidateId());
            return new ResponseEntity<>(candidateService.save(candidate), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //delete by id

//    @DeleteMapping("/{id}")
//    public String deleteCandidate(@PathVariable Long id) {
//        Optional<Candidate> candidateOptional = candidateService.getById(id);
//        if (candidateOptional.isPresent()) {
//            candidateService.remove(id);
//            return "redirect:/candidate";
//        } else {
//            return "error";
//        }
//    }
    @GetMapping("/delete/{id}")
    public String deleteCandidate(@PathVariable Long id) {
        Optional<Candidate> candidateOptional = candidateService.getById(id);
        if (candidateOptional.isPresent()) {
            candidateService.remove(id);
            return "redirect:/candidate/";
        } else {
            return "error";
        }
    }


    // edit
    @GetMapping("/edit/{id}")
    public String editCandidate(@PathVariable Long id, Model model) {
        Optional<Candidate> candidateOptional = candidateService.getById(id);
        if (candidateOptional.isPresent()) {
            Candidate candidate = candidateOptional.get();
            model.addAttribute("candidate", candidate);
            return "candidateedit";
        } else {
            return "error";
        }
    }


    @GetMapping("/add")
    public String addCandidate() {

        return "candidateadd";
    }
}
