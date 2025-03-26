package com.mentorlink.controller;

import com.mentorlink.model.Mentor;
import com.mentorlink.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    @GetMapping
    public String listMentors(Model model) {
        List<Mentor> mentors = mentorService.getAllMentors();
        model.addAttribute("mentors", mentors);
        return "mentor-list";
    }

    @GetMapping("/create")
    public String createMentorForm(Model model) {
        model.addAttribute("mentor", new Mentor());
        return "mentor-form";
    }

    @PostMapping("/save")
    public String saveMentor(@ModelAttribute Mentor mentor) {
        mentorService.saveMentor(mentor);
        return "redirect:/mentor";
    }

    @GetMapping("/delete/{id}")
    public String deleteMentor(@PathVariable Long id) {
        mentorService.deleteMentor(id);
        return "redirect:/mentor";
    }
}
