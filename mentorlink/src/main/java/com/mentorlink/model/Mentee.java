package com.mentorlink.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mentees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mentee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String course;
}
