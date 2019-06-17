package se331.lab.rest.repository;

import org.springframework.data.repository.CrudRepository;
import se331.lab.rest.entity.Lecturer;

import java.util.List;

public interface LecturerRepository  extends CrudRepository<Lecturer,Long> {
    List<Lecturer> findAll();
    Lecturer findBySurname(String surname);
}
