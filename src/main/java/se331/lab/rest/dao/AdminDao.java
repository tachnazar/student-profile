package se331.lab.rest.dao;

import se331.lab.rest.entity.Admin;
import se331.lab.rest.entity.Lecturer;

import java.util.List;

public interface AdminDao {
    List<Admin> getAdmins();
}
