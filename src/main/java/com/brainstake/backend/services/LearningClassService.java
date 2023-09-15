package com.brainstake.backend.services;
import com.brainstake.backend.d.t.o.LearningClassDto;
import com.brainstake.backend.exceptions.DataNotFoundException;
import com.brainstake.backend.models.LearningClass;
import com.brainstake.backend.repo.LearningClassRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor

public class LearningClassService {

    @Autowired
    private final LearningClassRepo learningClassRepo;


    public LearningClass save (LearningClassDto learningClassDto) {
        LearningClass learningClass = LearningClass.builder()
                .className(learningClassDto.getClassName())
                .classTeacher(learningClassDto.getClassTeacher())
                .build();

        return learningClassRepo.save(learningClass);
    }


//    public LearningClass findById(Long id) {
//        return LearningClassRepo.findById(id).orElseThrow(()-> new DataNotFoundException("Class with ID "+id+" was not found"));
//    }

    // Get All Senders
    public List<LearningClass> getClasses() {
        return learningClassRepo.findAll();
    }

}
