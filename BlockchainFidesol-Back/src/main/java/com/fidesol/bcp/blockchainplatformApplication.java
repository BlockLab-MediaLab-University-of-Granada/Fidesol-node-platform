package com.fidesol.bcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class blockchainplatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(blockchainplatformApplication.class, args);
	}

}
