package com.example.webprogr.security.services;

import com.example.webprogr.models.User;
import com.example.webprogr.repositories.UserRepository;
import com.example.webprogr.security.models.Role;
import com.example.webprogr.security.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    //Get all
    public List<Role> findAll(){
        return roleRepository.findAll();
    }

    //Get by id
    public Optional<Role> findById(int id){
        return roleRepository.findById(id);
    }

    //Delete
    public void  delete (int id){
        roleRepository.deleteById(id);
    }

    //Update
    public void save(Role role){
        roleRepository.save(role);
    }

    //dodaj rolu
    public void assignUserRole(Integer userId, Integer roleId){
        User user=userRepository.findById(userId).orElse(null);
        Role role=roleRepository.findById(roleId).orElse(null);
        Set<Role> userRoles=user.getRoles();
        userRoles.add(role);
        user.setRoles(userRoles);
        userRepository.save(user);

    }

    public void unassignUserRole(Integer userId, Integer roleId){
        User user=userRepository.findById(userId).orElse(null);
        Set<Role> userRoles=user.getRoles();
        userRoles.removeIf(x-> x.getId()==roleId);
        userRepository.save(user);

    }

    //get roles
    public Set<Role> getUserRoles(User user){
        return user.getRoles();
    }

    //role koje user nema -> mozemo mu ih dodijelit
    public Set<Role> getUserNotRoles(User user){
        return roleRepository.getUserNotRoles(user.getId());

    }
}
