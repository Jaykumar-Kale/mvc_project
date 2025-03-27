package com.mentorlink.service;

import com.mentorlink.model.QuizEntry;
import com.mentorlink.repository.QuizEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class QuizService {
    @Autowired
    private QuizEntryRepository quizEntryRepository;

    public void saveQuizEntry(QuizEntry quizEntry) {
        quizEntryRepository.save(quizEntry);
    }

    public List<QuizEntry> getQuizEntriesByDate(LocalDate date) {
        return quizEntryRepository.findByQuizDate(date);
    }

    public List<QuizEntry> getAllQuizEntries() {
        return quizEntryRepository.findAll();
    }
}
