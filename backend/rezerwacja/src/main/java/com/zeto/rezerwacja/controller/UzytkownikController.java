package com.zeto.rezerwacja.controller;

import com.zeto.rezerwacja.model.Rola;
import com.zeto.rezerwacja.model.Uzytkownik;
import com.zeto.rezerwacja.model.UzytkownikRola;
import com.zeto.rezerwacja.repo.UzytkownikRepository;
import com.zeto.rezerwacja.service.UzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/rejestracja")
@CrossOrigin("*")
public class UzytkownikController {

    @Autowired
    private UzytkownikService uzytkownikService;

    //tworzenie uzytkownika
    @PostMapping("/")
    public Uzytkownik stworzUzytkownik(@RequestBody Uzytkownik uzytkownik) throws Exception {

        Set<UzytkownikRola> role = new HashSet<>();

        Rola rola = new Rola();
        rola.setRolaId(1L);
        rola.setRolaNazwa("USER");

        UzytkownikRola uzytkownikRola = new UzytkownikRola();
        uzytkownikRola.setUzytkownik(uzytkownik);
        uzytkownikRola.setRola(rola);

        role.add(uzytkownikRola);
        return this.uzytkownikService.stworzUzytkownik(uzytkownik, role);
    }
    //znajdz uzytkownika po emailu

    @GetMapping("/{email}")
    public Uzytkownik getUzytkownik(@PathVariable("email") String email){
        return this.uzytkownikService.getUzytkownik(email);
    }

    //usun uzytkownika po id
    @DeleteMapping("/{idUzytkownik}")
    public void usunUzytkownik(@PathVariable("idUzytkownik") Long idUzytkownik){
        this.uzytkownikService.usunUzytkownik(idUzytkownik);
    }

    //update api

}
