package com.brainstake.backend.repo;
import com.brainstake.backend.models.LearningClass;
import com.brainstake.backend.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository <Student, Long> {

    List<Student> findByLearningClass(LearningClass learningClass);


}
