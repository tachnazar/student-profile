package se331.lab.rest.service;

import se331.lab.rest.entity.Lecturer;
import se331.lab.rest.entity.Student;

import java.util.List;

public interface LecturerAnotherService {
    Lecturer getLecturerByLastName(String lastname);
    List<Lecturer> getLecturerWhoseAdviseeGpaGreaterThan(double gpa);
}
