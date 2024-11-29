package com.example.demo.controller;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/users")
public class UserController {	

    
    private static final Logger logger = LogManager.getLogger(UserController.class);
    @Autowired
    UserService userService;

	@GetMapping("/{userId}")
	public Mono<String> getUser(@PathVariable Long userId) {
        logger.info("GET /users/"+userId);
		return userService.getUser(userId);
	}

}