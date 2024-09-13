package com.example.Trabajo.preentrega;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class TrabajoPreentregaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrabajoPreentregaApplication.class, args);
	}

}
