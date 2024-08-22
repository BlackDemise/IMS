package org.example.interviewmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/interview")
public class InterviewController {
    @GetMapping("/")
    public String interviewView() {
        return "interviewview";
    }
}
