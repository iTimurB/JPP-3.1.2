package com.itimtim.springboot.springbootbootstrap.dao;

import com.itimtim.springboot.springbootbootstrap.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleDao {
    Set<Role> getRolesByIds (List<Long> ids);
}
