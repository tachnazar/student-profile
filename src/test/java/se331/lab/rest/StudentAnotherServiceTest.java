package se331.lab.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import se331.lab.rest.entity.Lecturer;
import se331.lab.rest.entity.Student;
import se331.lab.rest.service.StudentAnotherService;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentAnotherServiceTest {
    @Autowired
    StudentAnotherService studentAnotherService;

    @Test
    public void testGetStudentByNameContains(){
        assertThat(studentAnotherService.getStudentByNameContains("ra"),containsInAnyOrder(
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

        assertThat(studentAnotherService.getStudentByNameContains("abc"),containsInAnyOrder());

    }
    @Test
    public void testGetStudentWhoseAdvisorNameIs(){
        assertThat(studentAnotherService.getStudentWhoseAdvisorNameIs("Pree"),containsInAnyOrder(
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
        assertThat(studentAnotherService.getStudentWhoseAdvisorNameIs("Suthep"),containsInAnyOrder());
    }
}
