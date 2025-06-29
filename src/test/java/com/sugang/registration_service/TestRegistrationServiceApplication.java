package com.sugang.registration_service;

import org.springframework.boot.SpringApplication;

public class TestRegistrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(RegistrationServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
