package com.example.hackcelerate.repositories;

import com.example.hackcelerate.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepo extends JpaRepository<Exam, Integer> {
}
