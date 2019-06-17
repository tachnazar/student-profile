package se331.lab.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Lecturer;
import se331.lab.rest.repository.LecturerRepository;

import java.util.List;
@Repository
public class LecturerDaoImpl implements LecturerDao {
    @Autowired
    LecturerRepository lecturerRepository;
    @Override
    public List<Lecturer> getLecturers() {
        return this.lecturerRepository.findAll();
    }
}
