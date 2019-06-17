package se331.lab.rest.service;

import se331.lab.rest.entity.Course;

import java.util.List;

public interface CourseAnotherService {
    List<Course> getCourseWhichStudentEnrolledMoreThan(int amountOfStudent);
    List<Course> getCourses();

    Course save(Course course);
    List<Course> getCourseWhoseStudentNameIs(String studentName);

}

