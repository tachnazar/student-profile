package se331.lab.rest.entity.dto;

import lombok.Builder;
import lombok.Data;
import se331.lab.rest.entity.Admin;
import se331.lab.rest.entity.Lecturer;

@Data
@Builder
public class AdminDTO {
    Long id;
    String name;
    String surname;

    public static AdminDTO getAdminDTO(Admin admin) {
        return AdminDTO.builder()
                .id(admin.getId())
                .name(admin.getName())
                .surname(admin.getSurname())
                .build();
    }

    public Admin getAdmin() {
        return Admin.builder()
                .id(this.id)
                .name(this.name)
                .surname(this.surname)
                .build();
    }
}
