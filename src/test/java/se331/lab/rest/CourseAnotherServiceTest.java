package se331.lab.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import se331.lab.rest.entity.Course;
import se331.lab.rest.entity.Lecturer;
import se331.lab.rest.service.CourseAnotherService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseAnotherServiceTest {
    @Autowired
    CourseAnotherService courseAnotherService;
    @Test
    public void TestGetCourseWhichStudentEnrolledMoreThan(){
        assertThat(courseAnotherService.getCourseWhichStudentEnrolledMoreThan(4),containsInAnyOrder(
                Course.builder()
                        .courseId("953234")
                        .courseName("Advance Software Development")
                        .content("The course for the smart students ")
                        .lecturer(Lecturer.builder()
                                .name("Chartchai")
                                .surname("Doungsa-ard")
                                .build())
                        .build()
        ));
        assertThat(courseAnotherService.getCourseWhichStudentEnrolledMoreThan(2),containsInAnyOrder(
                Course.builder()
                        .courseId("953234")
                        .courseName("Advance Software Development")
                        .content("The course for the smart students ")
                        .lecturer(Lecturer.builder()
                                .name("Chartchai")
                                .surname("Doungsa-ard")
                                .build())
                        .build(),
                Course.builder()
                        .courseId("953494")
                        .courseName("Selected Topics in SE 1")
                        .content("Python and Data mining Development")
                        .lecturer(Lecturer.builder()
                                .name("Pree")
                                .surname("Thiengburanathum")
                                .build())
                        .build()
        ));
        assertThat(courseAnotherService.getCourseWhichStudentEnrolledMoreThan(10),containsInAnyOrder(

        ));
    }
}
