package com.brainstake.backend.d.t.o;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
public class LearningClassDto  implements Serializable {
    private String className;
    private String classTeacher;
}
