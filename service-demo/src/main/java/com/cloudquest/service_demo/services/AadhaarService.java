package com.cloudquest.service_demo.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Service
public class AadhaarService {

    private static final Logger logger = LogManager.getLogger(AadhaarService.class);

	public String getAUA(Long aadhaar) {
        logger.info("get AUA for "+ aadhaar);
        try{
            Thread.sleep(2000L);
        }catch(Exception e){
            e.printStackTrace();
        }

        return String.format("AUA for %d is %s", aadhaar, "successful");
	}


    public String getKUA(Long aadhaar) {
        logger.info("get KUA for "+ aadhaar);
        
        // try{
        //     Thread.sleep(2000L);
        // }catch(Exception e){
        //     e.printStackTrace();
        // }

        return String.format("AUA for %d is %s", aadhaar, "successful");
	}

}   

