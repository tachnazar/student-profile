package se331.lab.rest.entity.dto;

import lombok.Builder;
import lombok.Data;
import se331.lab.rest.entity.Lecturer;
import se331.lab.rest.entity.Person;
import se331.lab.rest.entity.Student;
import se331.lab.rest.security.entity.Authority;

import java.util.List;

@Data
@Builder
public class UserDTO {
    Long id;
    String name;
    String surname;
    String image;
    List<Authority> authorities;

    public static UserDTO getUserDTO(Person person) {
        if (person instanceof Lecturer) {
            Lecturer lecturer = (Lecturer) person;
            return UserDTO.builder()
                    .id(lecturer.getId())
                    .name(lecturer.getName())
                    .surname(lecturer.getSurname())
                    .authorities(lecturer.getUser().getAuthorities())
                    .build();
        } else if (person instanceof Student) {
            Student student = (Student) person;
            return UserDTO.builder()
                    .id(student.getId())
                    .name(student.getName())
                    .surname(student.getSurname())
                    .image(student.getImage())
                    .authorities(student.getUser().getAuthorities())
                    .build();
        }
        return null;
    }
}
