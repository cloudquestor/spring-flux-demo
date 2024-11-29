package com.cloudquest.service_demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudquest.service_demo.services.AadhaarService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/aadhaar")
public class AadhaarController {	

    
    private static final Logger logger = LogManager.getLogger(AadhaarController.class);

    @Autowired
    AadhaarService aadhaarService;

	@GetMapping("/aua/{aadhaar}")
	public String getAUAStatus(@PathVariable Long aadhaar) {
        logger.info("GET AUA "+ aadhaar);
		return aadhaarService.getAUA(aadhaar);
	}

    @GetMapping("/kua/{aadhaar}")
	public String getKUAStatus(@PathVariable Long aadhaar) {
        logger.info("GET KUA "+ aadhaar);
		return aadhaarService.getKUA(aadhaar);
	}
	
}