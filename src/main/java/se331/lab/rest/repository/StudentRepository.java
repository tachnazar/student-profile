package se331.lab.rest.repository;

import org.springframework.data.repository.CrudRepository;
import se331.lab.rest.entity.Student;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student,Long> {
    List<Student> findAll();
    List<Student> findByNameContains(String name);
    List<Student> findByAdvisorName(String advisorName);
}
