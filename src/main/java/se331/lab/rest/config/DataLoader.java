package se331.lab.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se331.lab.rest.entity.Admin;
import se331.lab.rest.entity.Course;
import se331.lab.rest.entity.Lecturer;
import se331.lab.rest.entity.Student;
import se331.lab.rest.repository.AdminRepository;
import se331.lab.rest.repository.CourseRepository;
import se331.lab.rest.repository.LecturerRepository;
import se331.lab.rest.repository.StudentRepository;
import se331.lab.rest.security.entity.Authority;
import se331.lab.rest.security.entity.AuthorityName;
import se331.lab.rest.security.entity.User;
import se331.lab.rest.security.repository.AuthorityRepository;
import se331.lab.rest.security.repository.UserRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    LecturerRepository lecturerRepository;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    AuthorityRepository authorityRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        Student student1 = Student.builder()
                .studentId("SE-001")
                .name("Prayuth")
                .surname("The minister")
                .gpa(3.59)
                .image("http://13.250.41.39:8190/images/tu.jpg")
                .penAmount(15)
                .description("The great man ever!!!!")
                .build();
        Student student2 = Student.builder()
                .studentId("SE-002")
                .name("Cherprang")
                .surname("BNK48")
                .gpa(4.01)
                .image("http://13.250.41.39:8190/images/cherprang.png")
                .penAmount(2)
                .description("Code for Thailand")
                .build();
        Student student3 = Student.builder()
                .studentId("SE-003")
                .name("Nobi")
                .surname("Nobita")
                .gpa(1.77)
                .image("http://13.250.41.39:8190/images/nobita.gif")
                .penAmount(0)
                .description("Welcome to Olympic")
                .build();
        Student student4 = Student.builder()
                .studentId("SE-004")
                .name("Jurgen")
                .surname("Klopp")
                .gpa(2.56)
                .image("http://13.250.41.39:8190/images/klopp.jpg")
                .penAmount(200)
                .description("The manager")
                .build();
        Student student5 = Student.builder()
                .studentId("SE-005")
                .name("Mohamed")
                .surname("Salah")
                .gpa(2.44)
                .image("http://13.250.41.39:8190/images/salaaa.jpg")
                .penAmount(0)
                .description("The King of Egypt")
                .build();

        this.studentRepository.save(student1);
        this.studentRepository.save(student2);
        this.studentRepository.save(student3);
        this.studentRepository.save(student4);
        this.studentRepository.save(student5);

        Lecturer lecturer1 = Lecturer.builder()
                .name("Chartchai")
                .surname("Doungsa-ard")
                .build();
        Lecturer lecturer2 = Lecturer.builder()
                .name("Jayakrit")
                .surname("Hirisajja")
                .build();
        Lecturer lecturer3 = Lecturer.builder()
                .name("Pree")
                .surname("Thiengburanathum")
                .build();
        this.lecturerRepository.save(lecturer1);
        this.lecturerRepository.save(lecturer2);
        this.lecturerRepository.save(lecturer3);
        Admin admin1 = Admin.builder()
                .name("Tach")
                .surname("Nazarov")
                .build();
        this.adminRepository.save(admin1);
        Course course1 = Course.builder()
                .courseId("953331")
                .courseName("Component Based Software Dev")
                .content("Nothing just for fun")
                .build();
        Course course2 = Course.builder()
                .courseId("953xxx")
                .courseName("X project")
                .content("Do not know what to study")
                .build();
        Course course3 = Course.builder()
                .courseId("953494")
                .courseName("Selected Topics in SE 1")
                .content("Python and Data mining Development")
                .build();
        Course course4 = Course.builder()
                .courseId("953234")
                .courseName("Advance Software Development")
                .content("The course for the smart students ")
                .build();
        this.courseRepository.save(course1);
        this.courseRepository.save(course2);
        this.courseRepository.save(course3);
        this.courseRepository.save(course4);
        lecturer1.getAdvisees().add(student1);
        student1.setAdvisor(lecturer1);
        lecturer1.getAdvisees().add(student2);
        student2.setAdvisor(lecturer1);
        lecturer2.getAdvisees().add(student3);
        student3.setAdvisor(lecturer2);
        lecturer3.getAdvisees().add(student4);
        student4.setAdvisor(lecturer3);
        lecturer3.getAdvisees().add(student5);
        student5.setAdvisor(lecturer3);

        student1.getEnrolledCourses().add(course1);
        course1.getStudents().add(student1);
        student1.getEnrolledCourses().add(course2);
        course2.getStudents().add(student1);
        student2.getEnrolledCourses().add(course1);
        course1.getStudents().add(student2);
        student3.getEnrolledCourses().add(course2);
        course2.getStudents().add(student3);
        course3.getStudents().add(student4);
        course3.getStudents().add(student5);
        course3.getStudents().add(student1);
        student1.getEnrolledCourses().add(course3);
        student4.getEnrolledCourses().add(course3);
        student5.getEnrolledCourses().add(course3);
        course4.getStudents().add(student1);
        course4.getStudents().add(student2);
        course4.getStudents().add(student3);
        course4.getStudents().add(student4);
        course4.getStudents().add(student5);
        student1.getEnrolledCourses().add(course4);
        student2.getEnrolledCourses().add(course4);
        student3.getEnrolledCourses().add(course4);
        student4.getEnrolledCourses().add(course4);
        student5.getEnrolledCourses().add(course4);


        course1.setLecturer(lecturer2);
        lecturer2.getCourses().add(course1);
        course2.setLecturer(lecturer1);
        lecturer1.getCourses().add(course2);
        course3.setLecturer(lecturer3);
        lecturer3.getCourses().add(course3);
        course4.setLecturer(lecturer1);
        lecturer1.getCourses().add(course4);
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Authority auth1 = Authority.builder().name(AuthorityName.ROLE_LECTURER).build();
        Authority auth2 = Authority.builder().name(AuthorityName.ROLE_STUDENT).build();
        Authority auth3 = Authority.builder().name(AuthorityName.ROLE_ADMIN).build();
        User user1, user2, user3;
        user1 = User.builder()
                .username("admin")
                .password(encoder.encode("admin"))
                .firstname("Chartchai")
                .lastname("Doungsa-ard")
                .email("admin@admin.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2016, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user2 = User.builder()
                .username("yuth")
                .password(encoder.encode("yuth"))
                .firstname("Prayuth")
                .lastname("The minister")
                .email("enabled@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2016, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user3 = User.builder()
                .username("tach")
                .password(encoder.encode("tach"))
                .firstname("Tach")
                .lastname("Nazarov")
                .email("tach@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2016, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        authorityRepository.save(auth1);
        authorityRepository.save(auth2);
        authorityRepository.save(auth3);
        user1.getAuthorities().add(auth1);
        user1.getAuthorities().add(auth2);
        user2.getAuthorities().add(auth2);
        user3.getAuthorities().add(auth3);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        lecturer1.setUser(user1);
        user1.setAppUser(lecturer1);
        student1.setUser(user2);
        user2.setAppUser(student1);
        admin1.setUser(user3);
        user3.setAppUser(admin1);


    }


}
