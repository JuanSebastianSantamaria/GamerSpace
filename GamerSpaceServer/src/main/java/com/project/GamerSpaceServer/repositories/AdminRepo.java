package com.project.GamerSpaceServer.repositories;

import java.util.Optional;

import com.project.GamerSpaceServer.model.Admin;

import org.springframework.data.repository.CrudRepository;

public interface AdminRepo extends CrudRepository<Admin, Long> {
    Optional<Admin> findByUsername(String username);
}
