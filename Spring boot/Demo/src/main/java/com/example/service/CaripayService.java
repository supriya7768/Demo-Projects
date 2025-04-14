package com.example.service;

import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.annotation.Recover;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.ConnectException;

@Service
public class CaripayService {

    private final RestTemplate restTemplate;
    private int retryCount = 0;

    public CaripayService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Retryable(
            value = {ResourceAccessException.class},
            maxAttempts = 3,
            backoff = @Backoff(delay = 2000)
    )
    public ResponseEntity<String> invokeRemoteAPI() {
        retryCount++;
        System.out.println("Attempting API call... (Attempt #" + retryCount + " of 3)");

        String url = "https://api.millenniumci.net/caripayuat-api/rest/customers/0010025481/cards";
        return restTemplate.getForEntity(url, String.class);
    }

    @Recover
    public ResponseEntity<String> recover(ResourceAccessException e) {
        System.out.println("All " + retryCount + " retry attempts failed. Recovering...");
        return ResponseEntity.status(500).body("API failed after " + retryCount + " retries. Exception: " + e.getMessage()+ e.getClass());
    }
}

