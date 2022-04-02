package com.zeto.rezerwacja.service;

import com.zeto.rezerwacja.model.Uzytkownik;
import com.zeto.rezerwacja.model.UzytkownikRola;

import java.util.Set;

public interface UzytkownikService {

    //tworzenie uzytkownika

    public Uzytkownik stworzUzytkownik(Uzytkownik uzytkownik, Set<UzytkownikRola> UzytkownikRole) throws Exception;

    //znajdz uzytkownika po loginie

    public Uzytkownik getUzytkownik(String login);

    //usun uzytkownika po id

    public void usunUzytkownik(Long id);
}
