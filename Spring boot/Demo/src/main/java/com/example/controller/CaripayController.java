package com.example.controller;

import com.example.service.CaripayService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/caripay")
public class CaripayController {

    private final CaripayService caripayService;

    public CaripayController(CaripayService caripayService) {
        this.caripayService = caripayService;
    }

    @GetMapping("/call-bevertec")
    public ResponseEntity<String> callBevertec() {
        return caripayService.invokeRemoteAPI();  // ✅ Now Spring Retry will work
    }
}
