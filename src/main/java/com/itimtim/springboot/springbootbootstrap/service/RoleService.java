package com.itimtim.springboot.springbootbootstrap.service;

import com.itimtim.springboot.springbootbootstrap.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

    Set<Role> getRolesByIds (List<Long> ids);
}
