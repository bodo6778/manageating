package com.eap.manageating.dao;

import com.eap.manageating.model.Role;

public interface RoleDao {

    public Role findRoleByName(String theRoleName);

}
