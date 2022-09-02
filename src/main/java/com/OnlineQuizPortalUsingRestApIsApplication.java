package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com")
public class OnlineQuizPortalUsingRestApIsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineQuizPortalUsingRestApIsApplication.class, args);
		System.out.println("Server running");
	}

}
