package se331.lab.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import se331.lab.rest.service.AdminService;
import se331.lab.rest.service.LecturerService;

@Controller
@Slf4j
public class AdminController {
    @Autowired
    AdminService adminService;
    @GetMapping("/admins")
    public ResponseEntity getAllAdmins() {
        log.info("the controller is call");
        return ResponseEntity.ok(this.adminService.getAdmins());
    }
}
