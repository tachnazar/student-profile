package se331.lab.rest.entity.dto;

import lombok.Builder;
import lombok.Data;
import se331.lab.rest.entity.Lecturer;

@Data
@Builder
public class LecturerDTO {
    Long id;
    String name;
    String surname;

    public static LecturerDTO getLecturerDTO(Lecturer lecturer) {
        return LecturerDTO.builder()
                .id(lecturer.getId())
                .name(lecturer.getName())
                .surname(lecturer.getSurname())
                .build();
    }

    public Lecturer getLecturer() {
        return Lecturer.builder()
                .id(this.id)
                .name(this.name)
                .surname(this.surname)
                .build();
    }
}
