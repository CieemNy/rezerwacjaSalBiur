package com.zeto.rezerwacja.service.impl;

import com.zeto.rezerwacja.model.Rezerwacja;
import com.zeto.rezerwacja.repo.RezerwacjaRepository;
import com.zeto.rezerwacja.service.RezerwacjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class RezerwacjaServiceImpl implements RezerwacjaService {
    @Autowired
    private RezerwacjaRepository rezerwacjaRepository;

    @Override
    public Optional<Rezerwacja> getRezerwacjaPomieszczenie(Long idPomieszczenie) {
        return Optional.ofNullable(this.rezerwacjaRepository.findByIdPomieszczenie(idPomieszczenie));
    }

    @Override
    public Optional<Rezerwacja> getRezerwacjaUzytkownik(Long idUzytkownik) {
        return Optional.ofNullable(this.rezerwacjaRepository.findByIdUzytkownik(idUzytkownik));
    }

    @Override
    public Optional<Rezerwacja> getRezerwacja(Long idRezerwacja) {
        return this.rezerwacjaRepository.findById(idRezerwacja);
    }

    @Override
    public void usunRezerwacja(Long idRezerwacja) {
        this.rezerwacjaRepository.deleteById(idRezerwacja);
    }
}
