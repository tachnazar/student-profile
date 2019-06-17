package se331.lab.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Admin;
import se331.lab.rest.repository.AdminRepository;

import java.util.List;

@Repository
public class AdminAnotherDaoImpl implements AdminAnotherDao{
    @Autowired
    AdminRepository adminRepository;
    @Override
    public Admin getAdminByLastName(String lastName) {
        return adminRepository.findBySurname(lastName);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }
}
