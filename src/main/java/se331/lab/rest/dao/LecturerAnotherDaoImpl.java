package se331.lab.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Lecturer;
import se331.lab.rest.repository.LecturerRepository;

import java.util.List;
@Repository
public class LecturerAnotherDaoImpl implements LecturerAnotherDao{
    @Autowired
    LecturerRepository lecturerRepository;
    @Override
    public Lecturer getLecturerByLastName(String lastName) {
        return lecturerRepository.findBySurname(lastName);
    }

    @Override
    public List<Lecturer> getAllLecturer() {
        return lecturerRepository.findAll();
    }

    @Override
    public Lecturer getLecturerById(Long id) {
        return lecturerRepository.findById(id).orElse(null);
    }
}
