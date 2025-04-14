package com.bnt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.bnt.exception.InvalidDataException;
import com.bnt.exception.UserNotFoundException;
import com.bnt.model.Demo;
import com.bnt.repository.DemoRepository;

@Service
public class DemoService {

    @Autowired
    DemoRepository demoRepository;

    public Demo create(Demo demo){
        if (demo.getName() == null || demo.getName().isEmpty() ||
            demo.getCity() == null || demo.getCity().isEmpty() ||
             demo.getCompany() == null || demo.getCompany().isEmpty()) {
        throw new InvalidDataException("Invalid data provided: Name, City, and Company must not be empty");
    }
        return demoRepository.save(demo);
    }

    public List<Demo> getAll(){
        return demoRepository.findAll();
    }

    public void delete(Long id) {
        if (!demoRepository.existsById(id)) {
            throw new UserNotFoundException("User not found with id: " + id, id);
        }
        demoRepository.deleteById(id);
    }
    

    public Demo updateDemo(Demo demo) {
        Long id = demo.getId();
        if (!demoRepository.existsById(id)) {
            throw new UserNotFoundException("User not found with id: " + id, id);
        }
        return demoRepository.save(demo);
    }

    public Demo patchName(Long id, String name) {
        Demo existingDemo = demoRepository.findById(id).orElse(null);
        if (existingDemo == null) {
            throw new UserNotFoundException("User not found with id: " + id, id);
        }
        existingDemo.setName(name);
        return demoRepository.save(existingDemo);
    }

    public Demo getById(Long id) {
    Optional<Demo> optionalDemo = demoRepository.findById(id);
    if (optionalDemo.isPresent()) {
        return optionalDemo.get();
    } else {
        throw new UserNotFoundException("User not found with id: " + id, id);
    }
}

public List<Object[]> findAllDemoInfo() {
    return demoRepository.findAllDemoAndInfo();
}
    
}
