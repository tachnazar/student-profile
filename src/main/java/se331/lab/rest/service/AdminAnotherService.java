package se331.lab.rest.service;

import se331.lab.rest.entity.Admin;
import se331.lab.rest.entity.Lecturer;

import java.util.List;

public interface AdminAnotherService {
    Admin getAdminByLastName(String lastname);
}
