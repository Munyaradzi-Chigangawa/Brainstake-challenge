package com.brainstake.backend.services;
import com.brainstake.backend.dto.StudentDto;
import com.brainstake.backend.exceptions.DataNotFoundException;
import com.brainstake.backend.models.LearningClass;
import com.brainstake.backend.models.Student;
import com.brainstake.backend.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor

public class StudentService {
    @Autowired

    private final StudentRepo studentRepo;
    private final LearningClassService learningClassService;

    // Save Recipient
    public Student save (StudentDto student, Long classId) {

        LearningClass learningClass = learningClassService.findById(classId);


        Student student1 = Student.builder()
                .studentName(student.getStudentName())
                .attendance(student.getAttendance())
                .grade(student.getGrade())
                .learningClass(learningClass)
                .build();
        return studentRepo.save(student1);
    }


    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    public Student getStudent(Long id) {
        return studentRepo.findById(id)
                .orElseThrow(() -> new DataNotFoundException("No Students Found"));
    }


    public Student deleteStudent (Long id) {
        studentRepo.deleteAllById(Collections.singleton(id));
        return  null;
    }


    public List<Student> getStudents(long classId) {

        LearningClass learningClass = learningClassService.findById(classId);
        return studentRepo.findByLearningClass(learningClass);

    }

    public Student updateStudent (StudentDto studentDto, Long id) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new DataNotFoundException("No Student Found"));

        student.setStudentName(studentDto.getStudentName());
        student.setAttendance(studentDto.getAttendance());
        student.setGrade(studentDto.getGrade());

        return studentRepo.save(student);
    }

}
