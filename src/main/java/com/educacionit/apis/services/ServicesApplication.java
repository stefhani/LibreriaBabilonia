package com.educacionit.apis.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
/*
@EnableAutoConfiguration
* Parece que Intellij 14.0.3 (y lo más probable, versiones anteriores también) aún no está configurado
 * para reconocer la @SpringBootApplicationanotación.*/
public class ServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicesApplication.class, args);
	}

}
