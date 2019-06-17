package se331.lab.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.AdminAnotherDao;
import se331.lab.rest.dao.LecturerAnotherDao;
import se331.lab.rest.entity.Admin;
import se331.lab.rest.entity.Lecturer;
import se331.lab.rest.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminAnotherServiceImpl implements AdminAnotherService {
    @Autowired
    AdminAnotherDao adminAnotherDao;
    @Override
    public Admin getAdminByLastName(String lastname) {
        return adminAnotherDao.getAdminByLastName(lastname);
    }

}
