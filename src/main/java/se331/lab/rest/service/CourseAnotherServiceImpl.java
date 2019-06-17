package se331.lab.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se331.lab.rest.dao.CourseAnotherDao;
import se331.lab.rest.dao.LecturerAnotherDao;
import se331.lab.rest.entity.Course;
import se331.lab.rest.entity.Lecturer;
import se331.lab.rest.entity.Student;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseAnotherServiceImpl implements CourseAnotherService{
    private final
    CourseAnotherDao courseAnotherDao;
    @Autowired
    LecturerAnotherDao lecturerAnotherDao;
    @Autowired
    public CourseAnotherServiceImpl(CourseAnotherDao courseAnotherDao) {
        this.courseAnotherDao = courseAnotherDao;
    }

    @Override
    @Transactional
    public List<Course> getCourseWhichStudentEnrolledMoreThan(int amountOfStudent) {
        List<Course> courses = courseAnotherDao.findAll();
        return courses.stream().filter(course -> course.getStudents().size() > amountOfStudent).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public List<Course> getCourses() {
        return courseAnotherDao.findAll();
    }

    @Override
    @Transactional
    public Course save(Course course) {
        Lecturer lecturer = lecturerAnotherDao.getLecturerById(course.getLecturer().getId());
        course.setLecturer(lecturer);
        return courseAnotherDao.save(course);
    }
    @Override
    @Transactional
    public List<Course> getCourseWhoseStudentNameIs(String studentName) {
        return courseAnotherDao.getCourseWhoseStudentNameIs(studentName);
    }
}
