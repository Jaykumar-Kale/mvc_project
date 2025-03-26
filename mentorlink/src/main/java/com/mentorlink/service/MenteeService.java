package com.mentorlink.service;

import com.mentorlink.model.Mentee;
import com.mentorlink.repository.MenteeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MenteeService {
    @Autowired
    private MenteeRepository menteeRepository;

    public List<Mentee> getAllMentees() {
        return menteeRepository.findAll();
    }

    public Optional<Mentee> getMenteeById(Long id) {
        return menteeRepository.findById(id);
    }

    public Mentee saveMentee(Mentee mentee) {
        return menteeRepository.save(mentee);
    }

    public void deleteMentee(Long id) {
        menteeRepository.deleteById(id);
    }
}
