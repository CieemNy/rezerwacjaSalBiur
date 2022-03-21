package com.example.demo.controller;

import com.example.demo.Uzytkownik;
import com.example.demo.service.UzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/uzytkownik")
public class UzytkownikController {
    @Autowired
    private UzytkownikService uzytkownikService;

    @PostMapping
    public ResponseEntity<?> saveUzytkownik(@RequestBody Uzytkownik uzytkownik)
    {
        if(uzytkownikService.findBylogin(uzytkownik.getLogin()) != null)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(uzytkownikService.saveUzytkownik(uzytkownik), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<?> getAllUzytkownik() {
        return ResponseEntity.ok(uzytkownikService.findAll());
    }
}
