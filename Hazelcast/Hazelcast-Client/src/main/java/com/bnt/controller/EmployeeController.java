package com.bnt.controller;

import com.main.vijayaDemo.entity.Employee;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    HazelcastInstance hazelcastInstance;

    private IMap<Long, Employee> getEmployeeMap(){
        return hazelcastInstance.getMap("employeeMap");
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        IMap<Long, Employee> employeeMap = hazelcastInstance.getMap("employeeMap");
        //employeeMap.put(employee.getId(), employee);                //it will return the old value and set the new value
        employeeMap.set(employee.getId(), employee);                  //it will not return anything and will only set the value
        return ResponseEntity.ok(employee);
    }

    @GetMapping
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee emp = getEmployeeMap().get(id);
        if (emp != null){
            return  ResponseEntity.ok(emp);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
