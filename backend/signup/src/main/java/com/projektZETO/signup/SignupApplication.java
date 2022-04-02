package com.projektZETO.signup;

import com.projektZETO.signup.uzytkownik.Uzytkownik;
import com.projektZETO.signup.uzytkownik.UzytkownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SignupApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SignupApplication.class, args);
	}
	@Autowired
	private UzytkownikRepository uzytkownikRepository;
	@Override
	public void run(String... arg0) throws Exception {
		for(Uzytkownik uzytkownik : uzytkownikRepository.findAll()) {
			System.out.println("Id: " + uzytkownik.getIdUzytkownik());
			System.out.println("Imie: " + uzytkownik.getImie());
			System.out.println("Nazwisko: " + uzytkownik.getNazwisko());
			System.out.println("Email: " + uzytkownik.getEmail());
			System.out.println("Haslo: " + uzytkownik.getHaslo());
			System.out.println("Nr_Tele: " + uzytkownik.getNrTelefonu());
			System.out.println("Rola: " + uzytkownik.getUzytkownikRola());
			System.out.println("Uzytkownik:" + uzytkownikRepository.findAll());
			System.out.println("================================");
		}
	}
}
