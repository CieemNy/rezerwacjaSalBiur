package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UzytkownikRepository uzytkownikRepository) {
		return args -> {
			Uzytkownik Marian = new Uzytkownik(
					"DomenEZ","Dominik","Testowy"
					,"testowy@gmail.com","123456",
					"997211999"
			);
			uzytkownikRepository.save(Marian);
		};
	}
}
