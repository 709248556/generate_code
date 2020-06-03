package com.example.generate_code;

import com.example.generate_code.controller.GenerateController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class GenerateCodeApplication {

	public static void main(String[] args) {
//		SpringApplication.run(GenerateCodeApplication.class, args);
		for (int i =0;i<10;i++){
			System.out.println(String.valueOf(Math.abs(UUID.randomUUID().getMostSignificantBits())));
		}

	}

}
