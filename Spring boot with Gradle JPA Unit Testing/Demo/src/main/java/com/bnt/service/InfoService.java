package com.bnt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnt.model.Info;
import com.bnt.repository.InfoRepository;

@Service
public class InfoService {
    
    @Autowired
    InfoRepository infoRepository;

    public Info create(Info info){
        return infoRepository.save(info);
    }
}
