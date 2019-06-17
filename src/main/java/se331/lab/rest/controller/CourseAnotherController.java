package se331.lab.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import se331.lab.rest.entity.dto.CourseDTO;
import se331.lab.rest.service.CourseAnotherService;

import java.util.stream.Collectors;

@Controller
@Slf4j
public class CourseAnotherController {
    @Autowired
    CourseAnotherService courseAnotherService;

    @GetMapping("course/amount/{numOfStudent}")
    public ResponseEntity<?> getCourseWithAmountOfStudent(@PathVariable Integer numOfStudent){
        return ResponseEntity.ok(courseAnotherService.getCourseWhichStudentEnrolledMoreThan(numOfStudent));
    }
    @GetMapping("/courses")
    public ResponseEntity<?> getCourses(){
        log.info("get courses is called");
        return ResponseEntity.ok(courseAnotherService.getCourses().stream()
                .map(CourseDTO::getCourseListDTO).collect(Collectors.toList()));
    }

    @PostMapping("/courses")
    public ResponseEntity<?> saveCourses(@RequestBody CourseDTO courseDTO) {
        log.info("save courses is called");
        return ResponseEntity.ok(courseAnotherService.save(courseDTO.getCourse()));
    }
    @GetMapping("/course/student/{name}")
    public ResponseEntity<?> getCourseByStudentName(@PathVariable String name){
        return ResponseEntity.ok(courseAnotherService.getCourseWhoseStudentNameIs(name));
    }
}
