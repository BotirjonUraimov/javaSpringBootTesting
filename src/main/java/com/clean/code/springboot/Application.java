package com.clean.code.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Scheduled(fixedRate = 1000L)
//	public void startRate() {
//		System.out.println("Current Time => " + new Date());
//	}
//
//	@Scheduled(fixedDelay = 2000L)
//	public void startDelay() {
//		System.out.println("startDelay worked => " + new Date());
//	}

//	@Scheduled(initialDelay = 5000L,fixedDelay = 1000L)
//	public void startWithInitialDelay() {
//		System.out.println("startDelay worked => " + new Date());
//	}
//
	@Scheduled(cron = "40 51 15 * * *")
	public void startCron() {
		System.out.println("startCron worked => " + new Date());
	}


}
