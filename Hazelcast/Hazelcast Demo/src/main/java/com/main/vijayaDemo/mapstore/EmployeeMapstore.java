package com.main.vijayaDemo.mapstore;

import com.hazelcast.map.MapStore;
import com.main.vijayaDemo.entity.Employee;
import com.main.vijayaDemo.repository.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
public class EmployeeMapstore implements MapStore<Long, Employee> {

    @Autowired
    @Lazy
    EmployeeRepo employeeRepo;

    @Override
    public void store(Long key, Employee value) {
        log.info("store method");
        employeeRepo.save(value);
    }

    @Override
    public void storeAll(Map<Long, Employee> map) {
        log.info("storeAll method");
        employeeRepo.saveAll(map.values());
    }

    @Override
    public void delete(Long key) {
        log.info("delete method");
        employeeRepo.deleteById(key);
    }

    @Override
    public void deleteAll(Collection<Long> keys) {
       log.info("deleteAll method");
        employeeRepo.deleteAllById(keys);
    }

    @Override
    public Employee load(Long key) {
        log.info("load method");
        return employeeRepo.findById(key).orElse(null);
    }

    @Override
    public Map<Long, Employee> loadAll(Collection<Long> keys) {
        log.info("loadAll method");
        return employeeRepo.findAllById(keys).stream().collect(Collectors.toMap(Employee::getId, emp->emp));
    }

    @Override
    public Iterable<Long> loadAllKeys() {
        log.info("loadaAllKeys method");
        return employeeRepo.findAll().stream().map(Employee::getId).collect(Collectors.toList());
    }
}
