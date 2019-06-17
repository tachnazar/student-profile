package se331.lab.rest.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Profile("DtoDao")
@Repository
@Slf4j
public class StudentDaoImpl implements StudentDao {
    List<Student> students;

    public StudentDaoImpl() {
        this.students = new ArrayList<>();
        this.students.add(Student.builder()
                .id(1l)
                .studentId("SE-001")
                .name("Prayuth")
                .surname("The minister")
                .gpa(3.59)
                .image("http://13.250.41.39:8190/images/tu.jpg")
                .penAmount(15)
                .description("The great man ever!!!!")
                .build());
        this.students.add(Student.builder()
                .id(2l)
                .studentId("SE-002")
                .name("Cherprang ")
                .surname("BNK48")
                .gpa(4.01)
                .image("http://13.250.41.39:8190/images/cherprang.png")
                .penAmount(2)
                .description("Code for Thailand")
                .build());
        this.students.add(Student.builder()
                .id(3l)
                .studentId("SE-003")
                .name("Nobi")
                .surname("Nobita")
                .gpa(1.77)
                .image("http://13.250.41.39:8190/images/nobita.gif")
                .penAmount(0)
                .description("Welcome to Olympic")
                .build());
    }

    @Override
    public List<Student> getStudents() {
        log.info("Dto dao is called");
        return this.students;
    }

    @Override
    public Student getStudent(Long id) {
        return this.students.get(Math.toIntExact(id - 1));
    }

    @Override
    public Student saveStudent(Student student) {
        student.setId((long) this.students.size());
        this.students.add(student);
        return student;
    }
}
