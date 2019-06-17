package se331.lab.rest.dao;

import se331.lab.rest.entity.Lecturer;

import java.util.List;

public interface LecturerAnotherDao {
    Lecturer getLecturerByLastName(String lastName);
    List<Lecturer> getAllLecturer();

    Lecturer getLecturerById(Long id);

}
