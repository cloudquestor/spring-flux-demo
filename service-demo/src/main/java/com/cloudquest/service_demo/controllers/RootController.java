package com.cloudquest.service_demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/")
public class RootController {	

    
    private static final Logger logger = LogManager.getLogger(RootController.class);

	@GetMapping("/")
	public String getAuthorization() {
        logger.info("Home page called - return info");
		return "Please use /aaddhar for all payment apis";
	}

}