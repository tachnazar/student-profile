package se331.lab.rest.entity.dto;

import lombok.Builder;
import lombok.Data;
import se331.lab.rest.entity.Student;

@Data
@Builder
public class StudentDTO {

    Long id;
    String studentId;
    String name;
    String surname;
    double gpa;
    String image;
    boolean featured;
    int penAmount;

    public Student getStudent(){
        return Student.builder()
                .id(this.id)
                .studentId(this.studentId)
                .name(this.name)
                .surname(this.surname)
                .gpa(this.gpa)
                .image(this.image)
                .penAmount(this.penAmount)
                .build();
    }

}
