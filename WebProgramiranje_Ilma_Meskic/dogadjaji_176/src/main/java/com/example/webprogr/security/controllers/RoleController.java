package com.example.webprogr.security.controllers;


import com.example.webprogr.models.User;
import com.example.webprogr.security.models.Role;
import com.example.webprogr.security.services.RoleService;
import com.example.webprogr.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    //get all
    @GetMapping("roles")
    public String findAll(Model model){
        model.addAttribute("roles", roleService.findAll());
        return "role";
    }

    @RequestMapping("roles/findById")
    @ResponseBody
    public Optional<Role> findById(Integer id){
        return roleService.findById(id);
    }

    @PostMapping(value = "roles/addNew")
    public String addNew(Role role){
        roleService.save(role);
        return "redirect:/roles";
    }

    @RequestMapping(value = "roles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Role role){
        roleService.save(role);
        return "redirect:/roles";
    }

    @RequestMapping(value = "roles/delete", method = {RequestMethod.DELETE})
    public String delete(Integer id){
        roleService.delete(id);
        return "redirect:/roles";
    }

    @GetMapping("/security/user/Edit/{id}")
    public String editUser(@PathVariable Integer id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("userRoles", roleService.getUserRoles(user));
        model.addAttribute("userNotRoles", roleService.getUserNotRoles(user));
        return "/userEdit";
    }

    @RequestMapping("/security/role/assign/{userId}/{roleId}")
    public String assignRole(@PathVariable Integer userId,
                             @PathVariable Integer roleId){
        roleService.assignUserRole(userId, roleId);
        return "redirect:/security/user/Edit/"+userId;
    }

    @RequestMapping("/security/role/unassign/{userId}/{roleId}")
    public String unassignRole(@PathVariable Integer userId,
                               @PathVariable Integer roleId){
        roleService.unassignUserRole(userId, roleId);
        return "redirect:/security/user/Edit/"+userId;
    }

}
