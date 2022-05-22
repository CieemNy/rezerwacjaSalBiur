package com.zeto.rezerwacja.controller;

import com.zeto.rezerwacja.exception.ResourceNotFoundException;
import com.zeto.rezerwacja.model.Pomieszczenie;
import com.zeto.rezerwacja.model.Rezerwacja;
import com.zeto.rezerwacja.model.Uzytkownik;
import com.zeto.rezerwacja.repo.PomieszczenieRepository;
import com.zeto.rezerwacja.repo.RezerwacjaRepository;
import com.zeto.rezerwacja.service.PomieszczenieService;
import com.zeto.rezerwacja.service.RezerwacjaService;
import com.zeto.rezerwacja.service.impl.UzytkownikDetalisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
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
    @Autowired
    private PomieszczenieRepository pomieszczenieRepository;

    @PostMapping("/add")
    public Rezerwacja dodajRezerwacje(@RequestBody Rezerwacja rezerwacja, Principal principal,
                                       String dataStart,String dataStop,String id) throws Exception {
        Uzytkownik obecny = ((Uzytkownik) this.uzytkownikDetalisService.loadUserByUsername(principal.getName()));
        Long idPom = Long.valueOf(id).longValue();
        List<Pomieszczenie> pomieszczenia = pomieszczenieService.getAllPomieszczenia();
        Pomieszczenie obecne = null;
        for (Pomieszczenie pom : pomieszczenia) {
            if (pom.getIdPomieszczenie() == idPom) {
                obecne = pom;
            }
        }
        LocalDate dataStartu = LocalDate.parse(dataStart);
        LocalDate dataStopu = LocalDate.parse(dataStop);
        rezerwacja.setIdUzytkownik(obecny);
        rezerwacja.setDataStart(dataStartu);
        rezerwacja.setDataStop(dataStopu);
        rezerwacja.setIdPomieszczenie(obecne);
        return rezerwacjaRepository.save(rezerwacja);
    }

    //usuwanie rezerwacji
    @DeleteMapping("/delete/{id}")
    public void usunPomieszczenie(@PathVariable("id") Long id){
        this.rezerwacjaService.usunRezerwacja(id);
    }

    //wszystkie rezerwacje
    @GetMapping("/findall")
    List<Rezerwacja> show(Model map) {
        List<Rezerwacja> rezerwacje = rezerwacjaService.getAllRezerwacja();
        map.addAttribute("rezerwacje", rezerwacje);
        return rezerwacje;
    }

    //szukanie rezerwacji po jej id
    @GetMapping("/findid/{id}")
    public Rezerwacja znajdzRezerwacjaId(@PathVariable("id") Long id){
        return this.rezerwacjaService.getRezerwacja(id);
    }
    //szukanie rezerwacji po id pomieszczenia
    @GetMapping("/findidpom/{id}")
    public List<Rezerwacja> znajdzRezerwacjaIdPom(@PathVariable("id") Long id){
        return this.rezerwacjaService.getRezerwacjaPomieszczenie(id);
    }
    //szukanie rezerwacji po id uzytkownika
    @GetMapping("/findiduz/{id}")
    public List<Rezerwacja> znajdzRezerwacjaIdUz(@PathVariable("id") Long id){
        return this.rezerwacjaService.getRezerwacjaUzytkownik(id);
    }
    //edycja rezerwacji
    @PostMapping("/edit/{id}")
    public ResponseEntity<Rezerwacja> updateRezerwacja(@PathVariable long id,
                                                             @RequestBody String dataStart,String dataStop,String idPom)
    {
        Rezerwacja updateRezerwacja = rezerwacjaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rezerwacja o podanym id nie istnieje! Id:" + id));

        if (dataStart != null) {
            LocalDate dataStartu = LocalDate.parse(dataStart);
            updateRezerwacja.setDataStart(dataStartu);
        }
        if (dataStop != null) {
            LocalDate dataStopu = LocalDate.parse(dataStop);
            updateRezerwacja.setDataStop(dataStopu);
        }
        if (idPom != null) {
            Long idNew = Long.valueOf(idPom).longValue();
            List<Pomieszczenie> pomieszczenia = pomieszczenieService.getAllPomieszczenia();
            Pomieszczenie obecne = null;
            for (Pomieszczenie pom : pomieszczenia) {
                if (pom.getIdPomieszczenie() == idNew) {
                    obecne = pom;
                }
            }
            updateRezerwacja.setIdPomieszczenie(obecne);
        }
        rezerwacjaRepository.save(updateRezerwacja);
        return ResponseEntity.ok(updateRezerwacja);

    }
}
