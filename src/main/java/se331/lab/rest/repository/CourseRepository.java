package se331.lab.rest.repository;

import org.springframework.data.repository.CrudRepository;
import se331.lab.rest.entity.Course;
import se331.lab.rest.entity.Student;

import java.util.List;

public interface CourseRepository  extends CrudRepository<Course,Long> {
    List<Course> findAll();
    List<Course> findByStudentsName(String studentsName);

}
