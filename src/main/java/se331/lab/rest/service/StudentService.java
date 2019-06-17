package se331.lab.rest.service;

import se331.lab.rest.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    Student getStudent(Long id);
    Student saveStudent(Student student);

}
