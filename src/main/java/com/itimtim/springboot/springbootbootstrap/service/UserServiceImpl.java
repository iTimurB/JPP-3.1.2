package com.itimtim.springboot.springbootbootstrap.service;

import com.itimtim.springboot.springbootbootstrap.dao.UserDao;
import com.itimtim.springboot.springbootbootstrap.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User showUserById(long id) {
        return userDao.showUserById(id);
    }

    @Override
    @Transactional
    public void update(long id, User user) {
        userDao.update(id, user);
    }

    @Override
    @Transactional
    public void delete(long id) {
        userDao.delete(id);
    }

    @Override
    public User getUserByNameWithRoles(String name) {
        return userDao.getUserByNameWithRoles(name);
    }

}
