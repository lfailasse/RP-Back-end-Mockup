package com.lfailasse.RPBackend.Security.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.lfailasse.RPBackend.Security.Models.User;

public interface UserRepository extends JpaRepository<User, UUID> {

    UserDetails findByUsername(String username);

}
