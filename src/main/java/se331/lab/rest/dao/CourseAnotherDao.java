package se331.lab.rest.dao;

import se331.lab.rest.entity.Course;

import java.util.List;

public interface CourseAnotherDao {
    List<Course> findAll();

    Course save(Course course);
    List<Course> getCourseWhoseStudentNameIs(String studentName);
}
