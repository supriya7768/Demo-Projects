package com.bnt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bnt.model.Demo;
@Repository
public interface DemoRepository extends JpaRepository<Demo, Long>{

    @Query("SELECT d.id, d.name, d.city, d.company, i.experience, i.salary FROM Demo d JOIN Info i ON d.id = i.id")
     List<Object[]> findAllDemoAndInfo();

    
    
}