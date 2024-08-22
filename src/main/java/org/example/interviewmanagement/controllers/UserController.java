package org.example.interviewmanagement.controllers;

import org.example.interviewmanagement.entities.User;
import org.example.interviewmanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String userView(Model model) {
        List<User> userList = userRepository.findAll();
        model.addAttribute("userList", userList);
        return "userview";
    }

    @GetMapping("/add")
    public String viewAdd(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "useradd";
    }

    @PostMapping("/add/continue")
    public String processAdd(@ModelAttribute User user) {
        userRepository.save(user);
        return "userview";
    }


}
