package com.brainstake.backend.controllers;
import com.brainstake.backend.dto.LearningClassDto;
import com.brainstake.backend.models.LearningClass;
import com.brainstake.backend.services.LearningClassService;
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

public class LearningClassController {

    private final LearningClassService learningClassService;

     // Create Endpoint
    @PostMapping( value = "/addClass")
    public ResponseEntity <LearningClass> addSender (@RequestBody LearningClassDto classDto) {
        log.info("Class Added.");
        return new ResponseEntity<>(learningClassService.save(classDto), HttpStatus.CREATED);
    }


    // Read All Endpoint
    @GetMapping( value = "/getClasses")
    public ResponseEntity <List<LearningClass>> getClasses() {
        log.info("Classes Retrieved.");
        return new ResponseEntity<>(learningClassService.getClasses(), HttpStatus.OK);
    }
}
