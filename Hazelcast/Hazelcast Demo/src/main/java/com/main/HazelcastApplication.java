package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:hazelcast-config.xml")
public class HazelcastApplication {

	public static void main(String[] args) {
		SpringApplication.run(HazelcastApplication.class, args);
	}

}
