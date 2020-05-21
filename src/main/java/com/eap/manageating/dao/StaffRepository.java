package com.eap.manageating.dao;

import com.eap.manageating.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff,Integer> {
    public Staff findByUserName(String userName);
}
