package se331.lab.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import se331.lab.rest.entity.Course;
import se331.lab.rest.entity.Lecturer;
import se331.lab.rest.entity.Student;
import se331.lab.rest.repository.CourseRepository;
import se331.lab.rest.repository.LecturerRepository;
import se331.lab.rest.repository.StudentRepository;

import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestDataLoadingTest {
    @Autowired
    LecturerRepository lecturerRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    StudentRepository studentRepository;

    @Test
    public void contextLoads() {
        // test Lecturer
        assertThat(lecturerRepository.findAll(), containsInAnyOrder(
                Lecturer.builder()
                        .name("Chartchai")
                        .surname("Doungsa-ard")
                        .build(),
                Lecturer.builder()
                        .name("Jayakrit")
                        .surname("Hirisajja")
                        .build(),
                Lecturer.builder()
                        .name("Pree")
                        .surname("Thiengburanathum")
                        .build()));
        assertThat(courseRepository.findAll(), containsInAnyOrder(
                Course.builder()
                        .courseId("953331")
                        .courseName("Component Based Software Dev")
                        .content("Nothing just for fun")
                        .lecturer(Lecturer.builder()
                                .name("Jayakrit")
                                .surname("Hirisajja")
                                .build())
                        .build(),
                Course.builder()
                        .courseId("953xxx")
                        .courseName("X project")
                        .content("Do not know what to study")
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
                        .build(),
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
        assertThat(studentRepository.findAll(), containsInAnyOrder(
                Student.builder()
                        .studentId("SE-001")
                        .name("Prayuth")
                        .surname("The minister")
                        .gpa(3.59)
                        .image("http://13.250.41.39:8190/images/tu.jpg")
                        .penAmount(15)
                        .description("The great man ever!!!!")
                        .advisor(Lecturer.builder()
                                .name("Chartchai")
                                .surname("Doungsa-ard")
                                .build())
                        .build(),
                Student.builder()
                        .studentId("SE-002")
                        .name("Cherprang")
                        .surname("BNK48")
                        .gpa(4.01)
                        .image("http://13.250.41.39:8190/images/cherprang.png")
                        .penAmount(2)
                        .description("Code for Thailand")
                        .advisor(Lecturer.builder()
                                .name("Chartchai")
                                .surname("Doungsa-ard")
                                .build())
                        .build(),
                Student.builder()
                        .studentId("SE-003")
                        .name("Nobi")
                        .surname("Nobita")
                        .gpa(1.77)
                        .image("http://13.250.41.39:8190/images/nobita.gif")
                        .penAmount(0)
                        .description("Welcome to Olympic")
                        .advisor(Lecturer.builder()
                                .name("Jayakrit")
                                .surname("Hirisajja")
                                .build())
                        .build(),
                Student.builder()
                        .studentId("SE-004")
                        .name("Jurgen")
                        .surname("Klopp")
                        .gpa(2.56)
                        .image("http://13.250.41.39:8190/images/klopp.jpg")
                        .penAmount(200)
                        .description("The manager")
                        .advisor(Lecturer.builder()
                                .name("Pree")
                                .surname("Thiengburanathum")
                                .build())
                        .build(),
                Student.builder()
                        .studentId("SE-005")
                        .name("Mohamed")
                        .surname("Salah")
                        .gpa(2.44)
                        .image("http://13.250.41.39:8190/images/salaa.jpg")
                        .penAmount(0)
                        .description("The King of Egypt")
                        .advisor(Lecturer.builder()
                                .name("Pree")
                                .surname("Thiengburanathum")
                                .build())
                        .build()
        ));
    }

    @Test
    @Transactional
    public void testCourseRelationship() {
        //check the students in the course
        Course se331 = getCourse(courseRepository.findAll(), "953331");
        assertThat(se331.getStudents(), containsInAnyOrder(
                Student.builder()
                        .studentId("SE-001")
                        .name("Prayuth")
                        .surname("The minister")
                        .gpa(3.59)
                        .image("http://13.250.41.39:8190/images/tu.jpg")
                        .penAmount(15)
                        .description("The great man ever!!!!")
                        .advisor(Lecturer.builder()
                                .name("Chartchai")
                                .surname("Doungsa-ard")
                                .build())
                        .build(),
                Student.builder()
                        .studentId("SE-002")
                        .name("Cherprang")
                        .surname("BNK48")
                        .gpa(4.01)
                        .image("http://13.250.41.39:8190/images/cherprang.png")
                        .penAmount(2)
                        .description("Code for Thailand")
                        .advisor(Lecturer.builder()
                                .name("Chartchai")
                                .surname("Doungsa-ard")
                                .build())
                        .build()
        ));
        assertThat(se331.getLecturer(), is(Lecturer.builder()
                .name("Jayakrit")
                .surname("Hirisajja")
                .build()));
        Course sexxx = getCourse(courseRepository.findAll(), "953xxx");
        assertThat(sexxx.getStudents(), containsInAnyOrder(
                Student.builder()
                        .studentId("SE-001")
                        .name("Prayuth")
                        .surname("The minister")
                        .gpa(3.59)
                        .image("http://13.250.41.39:8190/images/tu.jpg")
                        .penAmount(15)
                        .description("The great man ever!!!!")
                        .advisor(Lecturer.builder()
                                .name("Chartchai")
                                .surname("Doungsa-ard")
                                .build())
                        .build(),
                Student.builder()
                        .studentId("SE-003")
                        .name("Nobi")
                        .surname("Nobita")
                        .gpa(1.77)
                        .image("http://13.250.41.39:8190/images/nobita.gif")
                        .penAmount(0)
                        .description("Welcome to Olympic")
                        .advisor(Lecturer.builder()
                                .name("Jayakrit")
                                .surname("Hirisajja")
                                .build())
                        .build()
        ));
        assertThat(sexxx.getLecturer(), is(Lecturer.builder()
                .name("Chartchai")
                .surname("Doungsa-ard")
                .build()));

    }

    @Test
    @Transactional
    public void testLecturer() {
        Lecturer dto = getLecturer(lecturerRepository.findAll(), "Chartchai");
        assertThat(dto.getCourses(), containsInAnyOrder(Course.builder()
                        .courseId("953xxx")
                        .courseName("X project")
                        .content("Do not know what to study")
                        .lecturer(Lecturer.builder()
                                .name("Chartchai")
                                .surname("Doungsa-ard")
                                .build())
                        .build(),
                Course.builder()
                        .courseId("953234")
                        .courseName("Advance Software Development")
                        .content("The course for the smart students ")
                        .lecturer(Lecturer.builder()
                                .name("Chartchai")
                                .surname("Doungsa-ard")
                                .build())
                        .build()));
        assertThat(dto.getAdvisees(), containsInAnyOrder(
                Student.builder()
                        .studentId("SE-001")
                        .name("Prayuth")
                        .surname("The minister")
                        .gpa(3.59)
                        .image("http://13.250.41.39:8190/images/tu.jpg")
                        .penAmount(15)
                        .description("The great man ever!!!!")
                        .advisor(Lecturer.builder()
                                .name("Chartchai")
                                .surname("Doungsa-ard")
                                .build())
                        .build(),
                Student.builder()
                        .studentId("SE-002")
                        .name("Cherprang")
                        .surname("BNK48")
                        .gpa(4.01)
                        .image("http://13.250.41.39:8190/images/cherprang.png")
                        .penAmount(2)
                        .description("Code for Thailand")
                        .advisor(Lecturer.builder()
                                .name("Chartchai")
                                .surname("Doungsa-ard")
                                .build())
                        .build()
        ));
        Lecturer jo = getLecturer(lecturerRepository.findAll(), "Jayakrit");
        assertThat(jo.getCourses(), containsInAnyOrder(
                Course.builder()
                        .courseId("953331")
                        .courseName("Component Based Software Dev")
                        .content("Nothing just for fun")
                        .lecturer(Lecturer.builder()
                                .name("Jayakrit")
                                .surname("Hirisajja")
                                .build())
                        .build()
        ));
        assertThat(jo.getAdvisees(), containsInAnyOrder(
                Student.builder()
                        .studentId("SE-003")
                        .name("Nobi")
                        .surname("Nobita")
                        .gpa(1.77)
                        .image("http://13.250.41.39:8190/images/nobita.gif")
                        .penAmount(0)
                        .description("Welcome to Olympic")
                        .advisor(Lecturer.builder()
                                .name("Jayakrit")
                                .surname("Hirisajja")
                                .build())
                        .build()
        ));

    }

    @Test
    @Transactional
    public void testStudent() {
        Student student1 = getStudent(studentRepository.findAll(), "SE-001");
        assertThat(student1.getAdvisor(), is(
                Lecturer.builder()
                        .name("Chartchai")
                        .surname("Doungsa-ard")
                        .build()
        ));
        assertThat(student1.getEnrolledCourses(), containsInAnyOrder(
                Course.builder()
                        .courseId("953331")
                        .courseName("Component Based Software Dev")
                        .content("Nothing just for fun")
                        .lecturer(Lecturer.builder()
                                .name("Jayakrit")
                                .surname("Hirisajja")
                                .build())
                        .build(),
                Course.builder()
                        .courseId("953xxx")
                        .courseName("X project")
                        .content("Do not know what to study")
                        .lecturer(Lecturer.builder()
                                .name("Chartchai")
                                .surname("Doungsa-ard")
                                .build())
                        .build(),
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
        Student student2 = getStudent(studentRepository.findAll(), "SE-002");
        assertThat(student2.getAdvisor(), is(
                Lecturer.builder()
                        .name("Chartchai")
                        .surname("Doungsa-ard")
                        .build()
        ));
        assertThat(student2.getEnrolledCourses(), containsInAnyOrder(
                Course.builder()
                        .courseId("953331")
                        .courseName("Component Based Software Dev")
                        .content("Nothing just for fun")
                        .lecturer(Lecturer.builder()
                                .name("Jayakrit")
                                .surname("Hirisajja")
                                .build())
                        .build(),
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
        Student student3 = getStudent(studentRepository.findAll(), "SE-003");
        assertThat(student3.getAdvisor(), is(
                Lecturer.builder()
                        .name("Jayakrit")
                        .surname("Hirisajja")
                        .build()
        ));
        assertThat(student3.getEnrolledCourses(), containsInAnyOrder(
                Course.builder()
                        .courseId("953xxx")
                        .courseName("X project")
                        .content("Do not know what to study")
                        .lecturer(Lecturer.builder()
                                .name("Chartchai")
                                .surname("Doungsa-ard")
                                .build())
                        .build(),
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

    }

    private Course getCourse(Set<Course> courses, String courseId) {
        return courses.stream().filter(course -> course.getCourseId().equals(courseId)).findFirst().orElse(null);
    }

    private Course getCourse(Iterable<Course> courses, String courseId) {
        Stream<Course> courseStream = StreamSupport.stream(courses.spliterator(), false);
        return courseStream.filter(course -> course.getCourseId().equals(courseId)).findFirst().orElse(null);
    }

    private Student getStudent(Set<Student> students, String studentId) {
        return students.stream().filter(student -> student.getStudentId().equals(studentId)).findFirst().orElse(null);
    }

    private Student getStudent(Iterable<Student> students, String studentId) {
        Stream<Student> studentStream = StreamSupport.stream(students.spliterator(), false);
        return studentStream.filter(student -> student.getStudentId().equals(studentId)).findFirst().orElse(null);
    }

    private Lecturer getLecturer(Iterable<Lecturer> students, String name) {
        Stream<Lecturer> studentStream = StreamSupport.stream(students.spliterator(), false);
        return studentStream.filter(lecturer -> lecturer.getName().equals(name)).findFirst().orElse(null);
    }

}
