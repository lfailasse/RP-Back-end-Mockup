package com.lfailasse.RPBackend.Security.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lfailasse.RPBackend.Security.DTOs.LoginResponseDTO;
import com.lfailasse.RPBackend.Security.Models.User;
import com.lfailasse.RPBackend.Security.Models.UserDTO;
import com.lfailasse.RPBackend.Security.Repositories.UserRepository;
import com.lfailasse.RPBackend.Security.Services.TokenService;
import com.lfailasse.RPBackend.Security.Services.UserService;

@CrossOrigin
@RequestMapping(value = "/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping(value = "/{username}")
    public UserDTO findByUsername(@PathVariable String username) throws Exception {
        return userService.findAccount(username);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponseDTO> findAccount(@RequestBody User cUser) throws Exception {
        var userpass = new UsernamePasswordAuthenticationToken(cUser.getUsername().toLowerCase(), cUser.getPassword());
        var auth = authenticationManager.authenticate(userpass);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        String subject = tokenService.validateToken(token);
        User user = (User) userRepository.findByUsername(subject);
        return ResponseEntity.ok(new LoginResponseDTO(token, user.getName(), user.getRole()));
    }

    @PostMapping()
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

}
