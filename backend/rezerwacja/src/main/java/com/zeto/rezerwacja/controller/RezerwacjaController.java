package com.zeto.rezerwacja.controller;

import com.zeto.rezerwacja.model.Pomieszczenie;
import com.zeto.rezerwacja.model.Rezerwacja;
import com.zeto.rezerwacja.model.Uzytkownik;
import com.zeto.rezerwacja.repo.RezerwacjaRepository;
import com.zeto.rezerwacja.service.PomieszczenieService;
import com.zeto.rezerwacja.service.RezerwacjaService;
import com.zeto.rezerwacja.service.impl.UzytkownikDetalisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/rezerwacja")
@CrossOrigin("*")
public class RezerwacjaController {

    @Autowired
    private RezerwacjaService rezerwacjaService;
    @Autowired
    private RezerwacjaRepository rezerwacjaRepository;
    @Autowired
    private UzytkownikDetalisServiceImpl uzytkownikDetalisService;
    @Autowired
    PomieszczenieService pomieszczenieService;

    @PostMapping("/add")
    public Rezerwacja dodajRezerwacje(@RequestBody Rezerwacja rezerwacja, Principal principal,
                                       String dataStart,String dataStop,String nazwa) throws Exception{
        Uzytkownik obecny = ((Uzytkownik)this.uzytkownikDetalisService.loadUserByUsername(principal.getName()));
//        Long idPom = Long.parseLong(idPomieszczenie);
//        Optional<Pomieszczenie> obecne = pomieszczenieService.findPomieszczenie(idPom);
        Pomieszczenie obecne = pomieszczenieService.getPomieszczenie(nazwa);
        LocalDate dataStartu = LocalDate.parse(dataStart);
        LocalDate dataStopu = LocalDate.parse(dataStop);
        rezerwacja.setDataStart(dataStartu);
        rezerwacja.setDataStop(dataStopu);
        rezerwacja.setIdUzytkownik(obecny);
        rezerwacja.setIdPomieszczenie(obecne);
        //TODO: naprawić pomieszczenie w rezerwacji
        return rezerwacjaRepository.save(rezerwacja);
    }
}
