package se331.lab.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Student;
import se331.lab.rest.repository.StudentRepository;

import java.util.List;
@Repository
public class StudentAnotherDaoImpl implements StudentAnotherDao {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public List<Student> getStudentByNameContains(String partOfName) {
        return studentRepository.findByNameContains(partOfName);
    }

    @Override
    public List<Student> getStudentWhoseAdvisorNameIs(String advisorName) {
        return studentRepository.findByAdvisorName(advisorName);
    }
}
