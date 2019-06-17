package se331.lab.rest.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Student;
import se331.lab.rest.repository.StudentRepository;

import java.util.List;

@Repository
@Profile("dbDao")
@Slf4j
public class StudentDBDaoImpl implements StudentDao {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public List<Student> getStudents() {
        log.info("find all student in db");
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        log.info("find student from id {} from database",id);
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student saveStudent(Student student) {
        log.info("save student to database");
        return studentRepository.save(student);
    }
}
