package com.mentorlink.controller;

import com.mentorlink.model.Mentee;
import com.mentorlink.service.MenteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mentee")
public class MenteeController {

    @Autowired
    private MenteeService menteeService;

    @GetMapping
    public String listMentees(Model model) {
        List<Mentee> mentees = menteeService.getAllMentees();
        model.addAttribute("mentees", mentees);
        return "mentee-list";
    }

    @GetMapping("/create")
    public String createMenteeForm(Model model) {
        model.addAttribute("mentee", new Mentee());
        return "mentee-form";
    }

    @PostMapping("/save")
    public String saveMentee(@ModelAttribute Mentee mentee) {
        menteeService.saveMentee(mentee);
        return "redirect:/mentee";
    }

    @GetMapping("/delete/{id}")
    public String deleteMentee(@PathVariable Long id) {
        menteeService.deleteMentee(id);
        return "redirect:/mentee";
    }
}
