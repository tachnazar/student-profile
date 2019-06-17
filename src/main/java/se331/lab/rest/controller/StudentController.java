package se331.lab.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import se331.lab.rest.entity.Student;
import se331.lab.rest.entity.dto.StudentDTO;
import se331.lab.rest.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class StudentController {

    @Autowired
    StudentService studentService;
    @GetMapping("/students")
    public ResponseEntity getAllStudent() {
        log.info("the controller is call");
        return ResponseEntity.ok(this.studentService.getStudents());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity getStudentById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.studentService.getStudent(id));
    }
    @PostMapping("/students")
    public ResponseEntity saveStudent(@RequestBody StudentDTO studentDTO) {
        return ResponseEntity.ok(this.studentService.saveStudent(studentDTO.getStudent()));
    }
}
