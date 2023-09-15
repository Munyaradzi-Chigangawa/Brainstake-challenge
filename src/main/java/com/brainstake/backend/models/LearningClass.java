package com.brainstake.backend.models;

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

public class LearningClass {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long classId;
    private String className;
    private String classTeacher;


}
