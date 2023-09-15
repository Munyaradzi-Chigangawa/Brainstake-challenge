package com.brainstake.backend.controllers;

import com.brainstake.backend.d.t.o.StudentDto;
import com.brainstake.backend.models.Student;
import com.brainstake.backend.services.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(value = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentService studentService;

    // Create Endpoint
    @PostMapping( value = "/addStudent")
    public ResponseEntity<Student> addStudent (@RequestBody StudentDto student, @RequestParam Long classId) {
        log.info("Student Added.");
        return new ResponseEntity<>(studentService.save(student,classId), HttpStatus.CREATED);
    }

    // Read All Endpoint
    @GetMapping( value = "/getStudents")
    public ResponseEntity<List<Student>> getStudents(@RequestParam long classId) {
        log.info("Student Retrieved.");
        return new ResponseEntity<>(studentService.getStudents(classId), HttpStatus.OK);
    }


    // Read Specific Record Endpoint
    @GetMapping( value = "/getStudent/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        log.info("Student Retrieved");
        return new ResponseEntity<>(studentService.getStudent(id), HttpStatus.OK);
    }

    // Delete Endpoint
    @DeleteMapping( value = "/deleteStudent{id}")
    public ResponseEntity<Student> deleteStudent (@PathVariable Long id) {
        log.info("Student Deleted.");
        return new ResponseEntity<>(studentService.deleteStudent(id), HttpStatus.OK);
    }

    // Update Endpoint
    @PutMapping( value = "/updateStudent/{id}")
    public ResponseEntity<Student> updateRecipient (@PathVariable Long id, @RequestBody StudentDto student, @RequestParam Long classId) {
        log.info("Student Updated.");
        return new ResponseEntity<>(studentService.updateStudent(student, id), HttpStatus.OK);
    }

}
