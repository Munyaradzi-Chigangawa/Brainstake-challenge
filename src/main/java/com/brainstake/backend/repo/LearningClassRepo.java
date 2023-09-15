package com.brainstake.backend.repo;
import com.brainstake.backend.models.LearningClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearningClassRepo extends JpaRepository <LearningClass, Long> {
    LearningClass findLearningClassByClassName(String className);
    LearningClass findLearningClassByClassId(Long classId);


}
