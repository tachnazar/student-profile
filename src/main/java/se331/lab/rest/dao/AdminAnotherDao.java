package se331.lab.rest.dao;

import se331.lab.rest.entity.Admin;

import java.util.List;

public interface AdminAnotherDao {
    Admin getAdminByLastName(String lastName);
    List<Admin> getAllAdmins();

    Admin getAdminById(Long id);

}
