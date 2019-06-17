package se331.lab.rest.service;

import se331.lab.rest.entity.Student;

import java.util.List;

public interface StudentAnotherService {
    List<Student> getStudentByNameContains(String partOfName);
    List<Student> getStudentWhoseAdvisorNameIs(String advisorName);
}
