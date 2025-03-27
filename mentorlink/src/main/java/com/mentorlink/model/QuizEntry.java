package com.mentorlink.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "quiz_entries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate quizDate;
    private String studentName;
    private String email;
    private Integer score;
    private boolean present;
}
