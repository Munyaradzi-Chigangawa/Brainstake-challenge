package com.brainstake.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class StudentDto {
    private String studentName;
    private String studentClass;
    private String grade;
    private String attendance;

}
