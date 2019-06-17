package se331.lab.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.AdminDao;
import se331.lab.rest.dao.LecturerDao;
import se331.lab.rest.entity.Admin;
import se331.lab.rest.entity.Lecturer;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;
    @Override
    public List<Admin> getAdmins() {
        return adminDao.getAdmins();
    }
}
