package se331.lab.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.LecturerAnotherDao;
import se331.lab.rest.entity.Lecturer;
import se331.lab.rest.entity.Student;

import java.util.ArrayList;
import java.util.List;
@Service
public class LecturerAnotherServiceImpl implements LecturerAnotherService {
    @Autowired
    LecturerAnotherDao lecturerAnotherDao;
    @Override
    public Lecturer getLecturerByLastName(String lastname) {
        return lecturerAnotherDao.getLecturerByLastName(lastname);
    }

    @Override
    public List<Lecturer> getLecturerWhoseAdviseeGpaGreaterThan(double gpa) {
        List<Lecturer> lecturers = lecturerAnotherDao.getAllLecturer();
        List<Lecturer> output = new ArrayList<>();
        for (Lecturer lecturer:
             lecturers) {
            double averageGpa = lecturer.getAdvisees().stream()
                    .mapToDouble(Student::getGpa)
                    .average()
                    .orElse(Double.NaN);
            if (averageGpa > gpa){
                output.add(lecturer);
            }

        }
        return output;
    }
}
