package com.itimtim.springboot.springbootbootstrap.service;


import com.itimtim.springboot.springbootbootstrap.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void save(User user);

    User showUserById(long id);

    void update(long id, User user);

    void delete(long id);

    User getUserByNameWithRoles(String name);
}
