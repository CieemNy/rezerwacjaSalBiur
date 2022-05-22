package com.zeto.rezerwacja.service.impl;

import com.zeto.rezerwacja.model.Pomieszczenie;
import com.zeto.rezerwacja.model.Rezerwacja;
import com.zeto.rezerwacja.repo.RezerwacjaRepository;
import com.zeto.rezerwacja.service.RezerwacjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RezerwacjaServiceImpl implements RezerwacjaService {
    @Autowired
    private RezerwacjaRepository rezerwacjaRepository;

    @Override
    public List<Rezerwacja> getRezerwacjaPomieszczenie(Long idPomieszczenie) {
        List<Rezerwacja> rezerwacje = rezerwacjaRepository.findAll();
        List<Rezerwacja> szukane = new ArrayList<>();
        for (Rezerwacja rez: rezerwacje){
            if (rez.getIdPomieszczenie().getIdPomieszczenie() == idPomieszczenie)
            {
                szukane.add(rez);
            }
        }
        return szukane;
    }

    @Override
    public List<Rezerwacja> getRezerwacjaUzytkownik(Long idUzytkownik) {
        List<Rezerwacja> rezerwacje = rezerwacjaRepository.findAll();
        List<Rezerwacja> szukane = new ArrayList<>();
        for (Rezerwacja rez : rezerwacje) {
            if (rez.getIdUzytkownik().getIdUzytkownik() == idUzytkownik) {
                szukane.add(rez);
            }
        }
        return szukane;
    }

    @Override
    public Rezerwacja getRezerwacja(Long idRezerwacja) {
        List<Rezerwacja> rezerwacje = rezerwacjaRepository.findAll();
        Rezerwacja szukane = null;
        for(Rezerwacja rez: rezerwacje)
        {
            if(rez.getIdRezerwacja()==idRezerwacja)
            {
                szukane = rez;
            }
        }
        return szukane;
    }

    @Override
    public void usunRezerwacja(Long idRezerwacja) {
        this.rezerwacjaRepository.deleteById(idRezerwacja);
    }

    @Override
    public List<Rezerwacja> getAllRezerwacja() {
        return rezerwacjaRepository.findAll();
    }
}
