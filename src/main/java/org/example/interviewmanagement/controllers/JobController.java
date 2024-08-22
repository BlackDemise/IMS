package org.example.interviewmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/job")
public class JobController {
    @GetMapping("/")
    public String jobView() {
        return "jobview";
    }
    @GetMapping(value = "/add", params = "addNewJob")
    public String addJob() {
        return "jobadd";
    }
    @GetMapping(value = "/add", params = "import")
    public String importJob() {
        return "jobimport";
    }
}
