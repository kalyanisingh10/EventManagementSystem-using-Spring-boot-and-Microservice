package com.example.eventms.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EventMsSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventMsSecurityApplication.class, args);
	}

}
