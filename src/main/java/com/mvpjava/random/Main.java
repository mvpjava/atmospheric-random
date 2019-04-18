package com.mvpjava.random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner	 {

	@Autowired Application application;
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	public void run(String... args) throws Exception {
        application.startApplication();
	}
}