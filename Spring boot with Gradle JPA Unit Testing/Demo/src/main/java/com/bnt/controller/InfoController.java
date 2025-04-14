package com.bnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bnt.model.Info;
import com.bnt.service.InfoService;


@RestController
public class InfoController {
    
    @Autowired
    InfoService infoService;

    @PostMapping("/info")
    public ResponseEntity<Info> create(@RequestBody Info info){
        Info createdInfo = infoService.create(info);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInfo);
    }

}
