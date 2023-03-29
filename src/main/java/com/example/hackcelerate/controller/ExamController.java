package com.example.hackcelerate.controller;

import com.example.hackcelerate.model.Exam;
import com.example.hackcelerate.repositories.ExamRepo;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class ExamController {
    private final ExamRepo examRepo;

    public ExamController(ExamRepo examRepo) {
        this.examRepo = examRepo;
    }

    @GetMapping("/exams")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "Basic Authentication")
    public List<Exam> getExams(){
        return new ArrayList<>(examRepo.findAll());
    }

    @PostMapping("/exam")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "Basic Authentication")
    public Exam createExam(@RequestBody Exam exam){
        return examRepo.save(exam);
    }
}
