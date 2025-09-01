package com.main.vijayaDemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee implements Serializable {

    @Id
    private Long id;
    private String name;
    private String department;
}
