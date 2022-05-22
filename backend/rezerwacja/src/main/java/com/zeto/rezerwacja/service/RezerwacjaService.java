package com.zeto.rezerwacja.service;

import com.zeto.rezerwacja.model.Pomieszczenie;
import com.zeto.rezerwacja.model.Rezerwacja;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface RezerwacjaService {

    public List<Rezerwacja> getRezerwacjaPomieszczenie(Long idPomieszczenie);

    public List<Rezerwacja> getRezerwacjaUzytkownik(Long idUzytkownik);

    public Rezerwacja getRezerwacja(Long idRezerwacja);

    public void usunRezerwacja(Long idRezerwacja);

    public List<Rezerwacja> getAllRezerwacja();

}
