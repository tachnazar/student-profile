package se331.lab.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import se331.lab.rest.service.LecturerAnotherService;
import se331.lab.rest.service.LecturerService;

@Controller
@Slf4j
public class LecturerAnotherController {
    @Autowired
    LecturerAnotherService lecturerService;
    @GetMapping("/lecturerSurname/{lastname}")
    public ResponseEntity getLectureBySurname(@PathVariable String lastname) {
        log.info("the controller is call");
        return ResponseEntity.ok(this.lecturerService.getLecturerByLastName(lastname));
    }
    @GetMapping("/lectureWithStudentGpa/{gpa}")
    public ResponseEntity getLectureBySurname(@PathVariable Double gpa) {
        log.info("the controller is call");
        return ResponseEntity.ok(this.lecturerService.getLecturerWhoseAdviseeGpaGreaterThan(gpa));
    }
}
