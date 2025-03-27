package com.mentorlink.controller;

import com.mentorlink.model.QuizEntry;
import com.mentorlink.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping
    public String showQuizEntries(Model model) {
        model.addAttribute("quizEntries", quizService.getAllQuizEntries());
        return "quiz-list";
    }

    @GetMapping("/date")
    public String showQuizByDate(@RequestParam String date, Model model) {
        LocalDate quizDate = LocalDate.parse(date);
        model.addAttribute("quizEntries", quizService.getQuizEntriesByDate(quizDate));
        return "quiz-list";
    }

    @GetMapping("/create")
    public String createQuizForm(Model model) {
        model.addAttribute("quizEntry", new QuizEntry());
        return "quiz-form";
    }

    @PostMapping("/save")
    public String saveQuizEntry(@ModelAttribute QuizEntry quizEntry) {
        quizEntry.setQuizDate(LocalDate.now()); // Set today's date
        quizService.saveQuizEntry(quizEntry);
        return "redirect:/quiz";
    }
}
