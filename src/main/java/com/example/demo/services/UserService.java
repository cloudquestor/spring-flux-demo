

package com.example.demo.service;

import java.time.Duration;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import io.netty.channel.ChannelOption;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import reactor.netty.http.client.HttpClient;
import reactor.netty.http.client.HttpClientRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class UserService {

    private static final Logger logger = LogManager.getLogger(UserService.class);

    /** demo to show this service is taking time */
	// public Mono<String> getUser(Long userId) {
    //     logger.info("getUser "+userId);
    //     // Artificial delay of 2s for demonstration purposes
	// 	return Mono.just("foo "+userId).delayUntil(
    //         a -> Mono.delay(Duration.ofSeconds(2))
    //     );
	// }

  

   /**
    * Call a dependent service - i.e. the aadhaar service to get the required response using webclient i.e. non-blocking
    */
    public Mono<String> getUser(Long userId) {
        logger.info("getUser "+userId);

        long aaddhar = 1234;

        HttpClient httpClient = HttpClient.create().option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000); //non-blocing io

        WebClient webClient = WebClient.builder()
            .clientConnector(new ReactorClientHttpConnector(httpClient))
            .build();

        return webClient.get()
		.uri(String.format("http://localhost:8090/aadhaar/aua/%d", aaddhar))
		.httpRequest(httpRequest -> {
			HttpClientRequest reactorRequest = httpRequest.getNativeRequest();
			// reactorRequest.responseTimeout(Duration.ofSeconds(3));
		})
		.retrieve()
		.bodyToMono(String.class);
       
	}

}   

