package com.bnt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		task();
	}

	@Scheduled(cron = "*/10 * * * * *")
	private static void task(){
		System.out.println("Hello");
	}

	/*
	 * The first * represents seconds.
	   The second * represents minutes.
	   The third * represents hours.
	   The fourth * represents the day of the month.
	   The fifth * represents the month.
	   The last * represents the day of the week.	
	 */
}
