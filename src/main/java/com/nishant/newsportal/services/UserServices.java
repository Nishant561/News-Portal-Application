package com.nishant.newsportal.services;


import com.nishant.newsportal.enums.RolesEnums;
import com.nishant.newsportal.model.Role;
import com.nishant.newsportal.model.User;
import com.nishant.newsportal.repository.RoleRepository;
import com.nishant.newsportal.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public boolean createNewUser(User user){
        boolean isSaved = false;
        Role userRole = roleRepository.findByRoleName(RolesEnums.USER);
        Role adminRole = roleRepository.findByRoleName(RolesEnums.ADMIN);
        user.getUserRoles().add(userRole);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
         User result = userRepository.save(user);

         if(result != null && result.getUserId()>0){
             isSaved = true;
             return  isSaved;
         }



        return false;




    }




}
