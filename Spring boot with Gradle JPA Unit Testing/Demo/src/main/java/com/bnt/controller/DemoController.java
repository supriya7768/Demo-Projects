package com.bnt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.bnt.model.Demo;
import com.bnt.service.DemoService;

@RestController
public class DemoController {

private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    DemoService demoService;

    @GetMapping("/hello")
    public ResponseEntity<String> check(){
    logger.info("The app is running");
    return ResponseEntity.ok("Hello");
   }

   @PostMapping("/save")
   public ResponseEntity<Demo> create(@RequestBody Demo demo){
    logger.info("The user is created : {}", demo);
      Demo createdUser = demoService.create(demo);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    
   }

   @GetMapping("/getAll")
   public ResponseEntity<List<Demo>> getAll(){
    logger.info("Got details of all users");
    List<Demo> getAllDemo = demoService.getAll();
    return ResponseEntity.status(HttpStatus.FOUND).body(getAllDemo);
   }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> delete(@PathVariable Long id){
    logger.info("Deleted the user with given id");
      demoService.delete(id);
      return ResponseEntity.ok("Deleted the user with id " + id);
   
   }

    @PutMapping("/update/{id}")
    public ResponseEntity<Demo> updateDemo(@PathVariable Long id, @RequestParam("name") String name, @RequestParam("city") String city, @RequestParam("company") String company) {
     logger.info("The user is updated as id {} name {}, city {}, company {}" ,id, name, city, company);
      Demo updateDemo = new Demo(id, name, city, company, null);
      Demo updatedDemo =  demoService.updateDemo(updateDemo);
      return ResponseEntity.status(HttpStatus.OK).body(updatedDemo); 
    }

    @PatchMapping("/patch-name/{id}")
     public ResponseEntity<Demo> patchName(@PathVariable Long id, @RequestParam("name") String name) {
        logger.info("The name of user is updated as id {} name {}",id, name);
          Demo patchName = demoService.patchName(id, name);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(patchName);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Demo> getById(@PathVariable Long id){
      logger.info("Got user by Id id {}",id);
        Demo demo = demoService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(demo);
    }

    @GetMapping("/demo-info")
    public ResponseEntity<List<Object[]>> getAllDemoInfo() {
        List<Object[]> demoInfoList = demoService.findAllDemoInfo();
        return ResponseEntity.status(HttpStatus.OK).body(demoInfoList);
    }
}
