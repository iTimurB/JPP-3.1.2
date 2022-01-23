package com.itimtim.springboot.springbootbootstrap.controller;

import com.itimtim.springboot.springbootbootstrap.model.User;
import com.itimtim.springboot.springbootbootstrap.service.RoleService;
import com.itimtim.springboot.springbootbootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public String showAllUsers(ModelMap model) {
        List<User> usersList = userService.getAllUsers();
        model.addAttribute("allUsers", usersList);
        return "/users";
    }

    @GetMapping("/users/{id}")
    public String showUserPage(@PathVariable("id") long userId, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.showUserById(userId));
        return "/show_user_page";
    }

    @GetMapping("/users/new")
    public String addUser(ModelMap modelMap) {
        modelMap.addAttribute("newUser", new User());
        return "/new";
    }

    @PostMapping("/users")
    public String createUser(@ModelAttribute("newUser") @Valid User user, BindingResult bindingResult, @RequestParam("rolesFromCreateUser") List<Long> roleIds) {
        if (bindingResult.hasErrors()) {
            return "/new";
        }
        user.setRoles(roleService.getRolesByIds(roleIds));
        userService.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/update/{id}")
    public String updateUser(@PathVariable("id") long userId, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.showUserById(userId));
        return "/update";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@Valid User user, BindingResult bindingResult, @RequestParam("rolesFromEditUser") List<Long> roleId) {
        if (bindingResult.hasErrors()) {
            return "/update";
        }

        user.setRoles(roleService.getRolesByIds(roleId));
        userService.update(user.getId(), user);
        return "redirect:/admin/users";
    }

    @GetMapping(value = "/users/delete/{id}")
    public String deleteUser(@PathVariable("id") long userId) {
        userService.delete(userId);
        return "redirect:/admin/users";
    }
}