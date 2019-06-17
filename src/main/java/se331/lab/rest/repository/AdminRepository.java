package se331.lab.rest.repository;

import org.springframework.data.repository.CrudRepository;
import se331.lab.rest.entity.Admin;
import se331.lab.rest.entity.Lecturer;

import java.util.List;

public interface AdminRepository extends CrudRepository<Admin,Long> {
    List<Admin> findAll();
    Admin findBySurname(String surname);
}
