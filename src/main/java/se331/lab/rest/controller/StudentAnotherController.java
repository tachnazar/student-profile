package se331.lab.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import se331.lab.rest.service.StudentAnotherService;

@Controller
public class StudentAnotherController {
    @Autowired
    StudentAnotherService studentAnotherService;
    @GetMapping("/student/name/{name}")
    public ResponseEntity<?> getStudentByName(@PathVariable String name){
        return ResponseEntity.ok(studentAnotherService.getStudentByNameContains(name));
    }

    @GetMapping("/student/advisor/{name}")
    public ResponseEntity<?> getStudentByAdvisorName(@PathVariable String name){
        return ResponseEntity.ok(studentAnotherService.getStudentWhoseAdvisorNameIs(name));
    }
}
