package com.brainstake.backend.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "class")
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "class_id")
    private LearningClass learningClass;
    private String studentName;
    private String studentClass;
    private String grade;
    private String attendance;

}
