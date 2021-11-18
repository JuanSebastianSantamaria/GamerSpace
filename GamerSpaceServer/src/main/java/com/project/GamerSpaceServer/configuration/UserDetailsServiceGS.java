package com.project.GamerSpaceServer.configuration;

import java.util.Optional;

import com.project.GamerSpaceServer.model.Admin;
import com.project.GamerSpaceServer.model.Customer;
import com.project.GamerSpaceServer.model.UserGS;
import com.project.GamerSpaceServer.repositories.AdminRepo;
import com.project.GamerSpaceServer.repositories.CustomerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceGS implements UserDetailsService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> customerOpt = customerRepo.findByUsername(username);
        Optional<Admin> adminOpt = adminRepo.findByUsername(username);
        User user = null;
        if(customerOpt.isPresent()){
            Customer customer = customerOpt.get();
            List<SimpleGrantedAuthority> roles = getRoles(customer);
            user = new User(customer.getUsername(), customer.getPassword(), roles);
        } else if(adminOpt.isPresent()){
            Admin admin = adminOpt.get();
            List<SimpleGrantedAuthority> roles = getRoles(admin);
            user = new User(admin.getUsername(), admin.getPassword(), roles);
        } else {
            throw new UsernameNotFoundException("Username not found");
        }
        return user;
    }

    private List<SimpleGrantedAuthority> getRoles(UserGS usuario) {
        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_" + usuario.getRol().getRol()));
        return roles;
    }
    
}
