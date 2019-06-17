package se331.lab.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import se331.lab.rest.service.AdminAnotherService;
import se331.lab.rest.service.LecturerAnotherService;

@Controller
@Slf4j
public class AdminAnotherController {
    @Autowired
    AdminAnotherService adminAnotherService;
    @GetMapping("/adminSurname/{lastname}")
    public ResponseEntity getAdminBySurname(@PathVariable String lastname) {
        log.info("the controller is call");
        return ResponseEntity.ok(this.adminAnotherService.getAdminByLastName(lastname));
    }
}
