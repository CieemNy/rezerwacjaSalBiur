package com.zeto.rezerwacja.controller;

import com.zeto.rezerwacja.model.Rezerwacja;
import com.zeto.rezerwacja.repo.RezerwacjaRepository;
import com.zeto.rezerwacja.service.RezerwacjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.Date;

@RestController
@RequestMapping("/rezerwacja")
@CrossOrigin("*")
public class RezerwacjaController {

    @Autowired
    private RezerwacjaService rezerwacjaService;
    @Autowired
    private RezerwacjaRepository rezerwacjaRepository;

//    @PostMapping("/add")
//    public Rezerwacja dodajRezerwacje(Rezerwacja rezerwacja, Principal principal,
//                                      @RequestBody Date dataStart,
//                                      @RequestBody Date dataStop) throws Exception{
//
//        rezerwacja.setDataStart(dataStart);
//        rezerwacja.setDataStop(dataStop);
//        rezerwacja.setIdUzytkownik(principal.);
//    }
}
