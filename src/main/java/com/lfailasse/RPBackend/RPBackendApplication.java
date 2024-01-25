package com.lfailasse.RPBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lfailasse.RPBackend.Security.Repositories.UserRepository;
import com.lfailasse.RPBackend.Security.Services.TokenService;

@SpringBootApplication
public class RPBackendApplication {

	@Autowired
	public TokenService tokenService;

	@Autowired
	public UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(RPBackendApplication.class, args);

	}

}
