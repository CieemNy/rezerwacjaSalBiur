package com.zeto.rezerwacja.service.impl;

import com.zeto.rezerwacja.model.Pomieszczenie;
import com.zeto.rezerwacja.model.Rezerwacja;
import com.zeto.rezerwacja.model.UzytkownikRola;
import com.zeto.rezerwacja.repo.PomieszczenieRepository;
import com.zeto.rezerwacja.service.PomieszczenieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PomieszczenieServiceImpl implements PomieszczenieService {

    @Autowired
    private PomieszczenieRepository pomieszczenieRepository;

    @Override
    public Pomieszczenie dodajPomieszczenie(Pomieszczenie pomieszczenie) throws Exception{
        Pomieszczenie nowe = pomieszczenieRepository.save(pomieszczenie);
        return nowe;
    }
    @Override
    public List<Pomieszczenie> getPomieszczenie(String nazwa){
        List<Pomieszczenie> pomieszczenia = pomieszczenieRepository.findAll();
        List<Pomieszczenie> szukane = new ArrayList<>();
        for (Pomieszczenie pom : pomieszczenia) {
            if (pom.getNazwa().matches(nazwa)) {
                szukane.add(pom);
            }
        }
        return szukane;
    }

    @Override
    public List<Pomieszczenie> getTypPomieszczenie(String typ) {
        List<Pomieszczenie> pomieszczenia = pomieszczenieRepository.findAll();
        List<Pomieszczenie> szukane = new ArrayList<>();
        for (Pomieszczenie pom : pomieszczenia) {
            if (pom.getTyp().matches(typ)) {
                szukane.add(pom);
            }
        }
        return szukane;
    }

    @Override
    public Pomieszczenie findPomieszczenie(Long idPomieszczenie){
        List<Pomieszczenie> pomieszczenia = pomieszczenieRepository.findAll();
        Pomieszczenie szukane = null;
        for(Pomieszczenie pom: pomieszczenia)
        {
            if(pom.getIdPomieszczenie()==idPomieszczenie)
            {
                szukane = pom;
            }
        }
        return szukane;
    }
    @Override
    public void usunPomieszczenie(Long idPomieszczenie){
        this.pomieszczenieRepository.deleteById(idPomieszczenie);
    }

    @Override
    public List<Pomieszczenie> getAllPomieszczenia() {
        return pomieszczenieRepository.findAll();
    }
}