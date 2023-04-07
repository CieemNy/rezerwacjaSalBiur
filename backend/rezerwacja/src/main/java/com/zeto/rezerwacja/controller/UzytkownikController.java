package com.zeto.rezerwacja.controller;

import com.zeto.rezerwacja.exception.ResourceNotFoundException;
import com.zeto.rezerwacja.model.Rola;
import com.zeto.rezerwacja.model.Uzytkownik;
import com.zeto.rezerwacja.model.UzytkownikRola;
import com.zeto.rezerwacja.repo.UzytkownikRepository;
import com.zeto.rezerwacja.service.UzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/uzytkownik")
@CrossOrigin("*")
public class UzytkownikController {

    @Autowired
    private UzytkownikService uzytkownikService;
    @Autowired
    private UzytkownikRepository uzytkownikRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //tworzenie uzytkownika
    @PostMapping("/add")
    public Uzytkownik stworzUzytkownik(@RequestBody Uzytkownik uzytkownik) throws Exception {


        uzytkownik.setHaslo(this.bCryptPasswordEncoder.encode(uzytkownik.getPassword()));

        Set<UzytkownikRola> role = new HashSet<>();

        Rola rola = new Rola();
        rola.setRolaId(1L);
        rola.setRolaNazwa("USER");

        UzytkownikRola uzytkownikRola = new UzytkownikRola();
        uzytkownikRola.setRola(rola);
        uzytkownikRola.setUzytkownik(uzytkownik);

        role.add(uzytkownikRola);
        return this.uzytkownikService.stworzUzytkownik(uzytkownik, role);
    }
    //znajdz uzytkownika po emailu

    @GetMapping("/find/{email}")
    public Uzytkownik getUzytkownik(@PathVariable("email") String email){
        return this.uzytkownikService.getUzytkownik(email);
    }
    //znajdz uzytkownika po id

    @GetMapping("/findid/{idUzytkownik}")
    public Optional<Uzytkownik> findUzytkownik(@PathVariable("idUzytkownik") Long idUzytkownik){
        return this.uzytkownikService.findUzytkownik(idUzytkownik);
    }

    //usun uzytkownika po id
    @DeleteMapping("/delete/{idUzytkownik}")
    public void usunUzytkownik(@PathVariable("idUzytkownik") Long idUzytkownik){
        this.uzytkownikService.usunUzytkownik(idUzytkownik);
    }

    //update api
    @PostMapping("/edit/{id}")
    public ResponseEntity<Uzytkownik> updateUzytkownik(@PathVariable long id, @RequestBody Uzytkownik uzytkownik) {
        Uzytkownik updateUzytkownik = uzytkownikRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Uzytkownik o podanym id nie istnieje! Id: " + id));

        if (uzytkownik.getImie() != null )
        {
            updateUzytkownik.setImie(uzytkownik.getImie());
        }
        if (uzytkownik.getNazwisko() != null )
        {
            updateUzytkownik.setNazwisko(uzytkownik.getNazwisko());
        }
        if (uzytkownik.getEmail() != null )
        {
            updateUzytkownik.setEmail(uzytkownik.getEmail());
        }
        if (uzytkownik.getHaslo() != null )
        {
            updateUzytkownik.setHaslo(this.bCryptPasswordEncoder.encode(uzytkownik.getHaslo()));
        }
        if (uzytkownik.getTelefon() != null )
        {
            updateUzytkownik.setTelefon(uzytkownik.getTelefon());
        }

        uzytkownikRepository.save(updateUzytkownik);

        return ResponseEntity.ok(updateUzytkownik);
    }

    @PostMapping("/editRola/{id}")
    public ResponseEntity<Uzytkownik> updateRola(@PathVariable long id) {
        Uzytkownik updateRola = uzytkownikRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Uzytkownik o podanym id nie istnieje! Id: " + id));


        Rola rola1 = new Rola();
        rola1.setRolaId(2L);
        rola1.setRolaNazwa("ADMIN");

        Set<UzytkownikRola> role = new HashSet<>();

        UzytkownikRola uzytkownikRola = new UzytkownikRola();
        uzytkownikRola.setRola(rola1);
        uzytkownikRola.setUzytkownik(updateRola);

        role.add(uzytkownikRola);
        updateRola.setUzytkownikRole(role);

        uzytkownikRepository.save(updateRola);
        return ResponseEntity.ok(updateRola);
    }

}
