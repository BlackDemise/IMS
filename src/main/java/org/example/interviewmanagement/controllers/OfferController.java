package org.example.interviewmanagement.controllers;

import org.example.interviewmanagement.entities.*;
import org.example.interviewmanagement.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;

@Controller
@RequestMapping("/offer")
public class OfferController {
    OfferRepository offerRepository;

    @Autowired
    public OfferController(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @GetMapping("/")
    public String viewAll(Model model) {
        model.addAttribute("offerList", offerRepository.findAll());
        return "offerview";
    }

    @GetMapping("/detail")
    public String viewOne(Model model, @RequestParam Long offerId) {
        model.addAttribute("offer", offerRepository.findById(Math.toIntExact(offerId)));
        return "offerdetail";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam Long offerId) {
        model.addAttribute("offer", offerRepository.findById(Math.toIntExact(offerId)));
        return "offeredit";
    }

    @GetMapping("/add")
    public String add() {
        return "offeradd";
    }

    @GetMapping("/add/continue")
    public String processAddOrEdit(Model model,
                             @RequestParam BigDecimal salary,
                             @RequestParam LocalDate contractStart,
                             @RequestParam LocalDate contractEnd,
                             @RequestParam LocalDate dueDate,
                             @RequestParam String offerNote,
                             @RequestParam String contractType,
                             @RequestParam String position,
                             @RequestParam String department,
                             @RequestParam String level) {
        Offer offer = Offer.builder()
                .offerBasicSalary(salary)
                .offerContractPeriodFrom(contractStart)
                .offerContractPeriodTo(contractEnd)
                .offerDueDate(dueDate)
                .approver((User) model.getAttribute("approver"))
                .candidate((Candidate) model.getAttribute("candidate"))
                .userOfferDepartment(department)
                .interview((Interview) model.getAttribute("interviewInfo"))
                .jobOfferLevel(level)
                .candidatePosition(position)
                .recruiter((User) model.getAttribute("recruiter"))
                .offerContract(contractType)
                .offerNote(offerNote)
                .build();
        offerRepository.save(offer);
        return "redirect:/offer/";
    }

    @GetMapping("/import")
    public String importOffer() {
        return "offerview";
    }

}
