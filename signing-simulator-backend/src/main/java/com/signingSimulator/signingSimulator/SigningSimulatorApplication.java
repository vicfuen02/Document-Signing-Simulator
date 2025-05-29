package com.signingSimulator.signingSimulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SigningSimulatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SigningSimulatorApplication.class, args);
		System.out.println("Signing service running ...");
	}

}
