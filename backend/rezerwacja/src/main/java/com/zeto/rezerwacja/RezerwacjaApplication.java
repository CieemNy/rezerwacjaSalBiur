package com.zeto.rezerwacja;

import com.zeto.rezerwacja.model.Rola;
import com.zeto.rezerwacja.model.Uzytkownik;
import com.zeto.rezerwacja.model.UzytkownikRola;
import com.zeto.rezerwacja.service.UzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class RezerwacjaApplication implements CommandLineRunner {
	@Autowired
	private UzytkownikService uzytkownikService;

	public static void main(String[] args) {

		SpringApplication.run(RezerwacjaApplication.class, args);


	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting code");

//		Uzytkownik uzytkownik = new Uzytkownik();
//		uzytkownik.setImie("jasiek2");
//		uzytkownik.setNazwisko("jasiek2");
//		uzytkownik.setHaslo("test");
//		uzytkownik.setEmail("test5@gmail.com");
//		uzytkownik.setTelefon("123123");
//
//		Rola rola1 = new Rola();
//		rola1.setRolaId(1L);
//		rola1.setRolaNazwa("USER");
//
//		Set<UzytkownikRola> uzytkownikRolaSet= new HashSet<>();
//		UzytkownikRola uzytkownikRola= new UzytkownikRola();
//		uzytkownikRola.setRola(rola1);
//		uzytkownikRola.setUzytkownik(uzytkownik);
//
//		uzytkownikRolaSet.add(uzytkownikRola);
//
//		Uzytkownik uzytkownik1 =this.uzytkownikService.stworzUzytkownik(uzytkownik, uzytkownikRolaSet);
//		System.out.println(uzytkownik1.getEmail());


	}
}
