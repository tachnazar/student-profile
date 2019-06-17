package se331.lab.rest.dao;

import se331.lab.rest.entity.Student;

import java.util.List;

public interface StudentAnotherDao {
    List<Student> getStudentByNameContains(String partOfName);
    List<Student> getStudentWhoseAdvisorNameIs(String advisorName);
}
