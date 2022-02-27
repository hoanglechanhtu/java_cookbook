package com.example.demoweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoWebApplication {

	public static void main(String[] args) {
		System.out.println(String.format("id = %08.2f",423.147));
		SpringApplication.run(DemoWebApplication.class, args);
	}

}


