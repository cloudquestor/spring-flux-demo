package com.cloudquest.client_demo.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class ClientService {

    private static final Logger logger = LogManager.getLogger(ClientService.class);

	public String getAuthorization(Long userId) {
        logger.info("getAuthorization for "+userId);

        RestTemplate restTemplate = new RestTemplate();
        String authHubServiceURL = "http://localhost:8080/users";
        ResponseEntity<String> response = restTemplate.getForEntity(String.format("%s/%d", authHubServiceURL, userId), String.class);
        String res = response.getBody();
        logger.info(String.format("Resonse Body is { %s }", res));
        return res;
	}

}   

