package com.mentorlink.repository;

import com.mentorlink.model.QuizEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface QuizEntryRepository extends JpaRepository<QuizEntry, Long> {
    List<QuizEntry> findByQuizDate(LocalDate date);
}
