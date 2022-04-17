package com.zensar.olx;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;

@SpringBootApplication
@EnableEurekaClient

public class OlxProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(OlxProject1Application.class, args);
	}

}
