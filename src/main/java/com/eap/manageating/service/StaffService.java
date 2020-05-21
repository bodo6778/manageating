package com.eap.manageating.service;

import com.eap.manageating.model.Staff;
import com.eap.manageating.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface StaffService extends UserDetailsService {
    public List<Staff> findAll();

    public Staff findById(int theId);

    public void save(Staff staff);

    public void deleteById(int theId);

    public Staff findByUserName(String userName);

    public void save(CrmUser crmUser);
}
