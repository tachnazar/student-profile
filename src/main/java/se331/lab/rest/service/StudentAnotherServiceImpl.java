package se331.lab.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se331.lab.rest.dao.StudentAnotherDao;
import se331.lab.rest.entity.Student;

import java.util.List;
@Service
public class StudentAnotherServiceImpl implements StudentAnotherService {
    @Autowired
    StudentAnotherDao studentAnotherDao;
    @Override
    @Transactional
    public List<Student> getStudentByNameContains(String partOfName) {
        return studentAnotherDao.getStudentByNameContains(partOfName);
    }

    @Override
    @Transactional
    public List<Student> getStudentWhoseAdvisorNameIs(String advisorName) {
        return studentAnotherDao.getStudentWhoseAdvisorNameIs(advisorName);
    }
}
