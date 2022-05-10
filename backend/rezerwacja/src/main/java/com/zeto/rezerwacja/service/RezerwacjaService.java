package com.zeto.rezerwacja.service;

import com.zeto.rezerwacja.model.Rezerwacja;

import java.sql.Date;
import java.util.Optional;

public interface RezerwacjaService {

    public Optional<Rezerwacja> getRezerwacjaPomieszczenie(Long idPomieszczenie);

    public Optional<Rezerwacja> getRezerwacjaUzytkownik(Long idUzytkownik);

    public Optional<Rezerwacja> getRezerwacja(Long idRezerwacja);

    public void usunRezerwacja(Long idRezerwacja);


}
