package com.lfailasse.RPBackend.Security.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lfailasse.RPBackend.Security.Models.User;
import com.lfailasse.RPBackend.Security.Models.UserDTO;
import com.lfailasse.RPBackend.Security.Repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passEncoder() {
        return new BCryptPasswordEncoder();
    }

    public User createUser(User user) {

        User fUser = (User) userRepository.findByUsername(user.getUsername().toLowerCase());

        if (fUser != null) {
            throw new Error("Usuário já existente");
        }
        user.setPassword(passEncoder().encode(user.getPassword()));
        user.setUsername(user.getUsername().toLowerCase());
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public UserDTO findAccount(String username) throws Exception {
        UserDTO finalUser = new UserDTO();
        User fUser = (User) userRepository.findByUsername(username.toLowerCase());
        if (fUser != null) {
                finalUser.setId(fUser.getId());
                finalUser.setName(fUser.getName());
                finalUser.setRole(fUser.getRole());
                finalUser.setUsername(fUser.getUsername());
            return finalUser;
        } else {
            throw new Exception("Usuário não encontrado");
        }
    }
}
