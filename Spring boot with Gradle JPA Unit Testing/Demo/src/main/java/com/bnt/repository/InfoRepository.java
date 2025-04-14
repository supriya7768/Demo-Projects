package com.bnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bnt.model.Info;

public interface InfoRepository extends JpaRepository<Info, Long>{
    
}
