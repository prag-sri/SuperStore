package com.example.SuperStore;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class SuperStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperStoreApplication.class, args);
	}

}
