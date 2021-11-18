package com.project.GamerSpaceServer.services;

import java.util.Optional;

import com.project.GamerSpaceServer.model.Admin;
import com.project.GamerSpaceServer.repositories.AdminRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService{
    @Autowired
    private AdminRepo adminRepo;

    @Override
    public Admin updateAdmin(Admin admin) {
        Admin editedAdmin = findAdminById(admin.getUserId());
        editedAdmin.setFullname(admin.getFullname());
        editedAdmin.setEmail(admin.getEmail());
        editedAdmin.setPhoneNumber(admin.getPhoneNumber());
        return adminRepo.save(editedAdmin);
    }

    @Override
    public Admin findAdminById(Long id) {
        return adminRepo.findById(id).get();
    }

    @Override
    public Optional<Admin> findByUsername(String username) {
        return adminRepo.findByUsername(username);
    }
}
