package com.cloudquest.client_demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudquest.client_demo.services.ClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/payments")
public class ClientController {	

    
    private static final Logger logger = LogManager.getLogger(ClientController.class);

    @Autowired
    ClientService clientService;

	@GetMapping("/{userId}")
	public String getAuthorization(@PathVariable Long userId) {
        logger.info("GET /users/"+userId);
		return clientService.getAuthorization(userId);
	}

    

	

}