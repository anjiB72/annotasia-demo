package com.chapter.backend.customannotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.chapter.backend.customannotations.model")
public class CustomannotationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomannotationsApplication.class, args);
	}

}
