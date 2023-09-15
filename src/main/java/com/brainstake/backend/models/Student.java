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
@Table(name = "student")
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "classId" , foreignKey = @ForeignKey(name = "class_id_fk") ,referencedColumnName = "classId")
    private LearningClass learningClass;
    private String studentName;
    private String grade;
    private String attendance;

}
