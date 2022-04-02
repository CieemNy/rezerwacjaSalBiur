package com.zeto.rezerwacja.controller;

import com.zeto.rezerwacja.model.Rola;
import com.zeto.rezerwacja.model.Uzytkownik;
import com.zeto.rezerwacja.model.UzytkownikRola;
import com.zeto.rezerwacja.service.UzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
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
        rola.setRolaId(45L);
        rola.setRolaNazwa("Normal");

        UzytkownikRola uzytkownikRola = new UzytkownikRola();
        uzytkownikRola.setUzytkownik(uzytkownik);
        uzytkownikRola.setRola(rola);

        role.add(uzytkownikRola);
        return this.uzytkownikService.stworzUzytkownik(uzytkownik, role);
    }
    //znajdz uzytkownika po loginie

    @GetMapping("/{login}")
    public Uzytkownik getUzytkownik(@PathVariable("login") String login){
        return this.uzytkownikService.getUzytkownik(login);
    }

    //usun uzytkownika po id
    @DeleteMapping("/{id}")
    public void usunUzytkownik(@PathVariable("id") Long id){
        this.uzytkownikService.usunUzytkownik(id);
    }

    //update api


}
