package com.project.GamerSpaceServer.services;

import java.util.Optional;

import com.project.GamerSpaceServer.model.Admin;

public interface IAdminService {
    public Admin updateAdmin(Admin admin);
    public Admin findAdminById(Long id);
    public Optional<Admin> findByUsername(String username);
}
