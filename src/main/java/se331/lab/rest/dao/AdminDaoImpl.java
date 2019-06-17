package se331.lab.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Admin;
import se331.lab.rest.entity.Lecturer;
import se331.lab.rest.repository.AdminRepository;
import se331.lab.rest.repository.LecturerRepository;

import java.util.List;

@Repository
public class AdminDaoImpl implements AdminDao {
    @Autowired
    AdminRepository adminRepository;
    @Override
    public List<Admin> getAdmins() {
        return this.adminRepository.findAll();
    }
}
