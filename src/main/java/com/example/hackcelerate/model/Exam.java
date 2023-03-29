package com.example.hackcelerate.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Schema(name = "Exam Table")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String examName;

    @Column(nullable = false)
    private String examDate;

    @Column(nullable = false)
    private String examURL;

    @Column(nullable = false)
    private String examResourceUrl;
}
