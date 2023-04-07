<<<<<<< HEAD
package com.zeto.rezerwacja.service;

import com.zeto.rezerwacja.model.Uzytkownik;
import com.zeto.rezerwacja.model.UzytkownikRola;


import java.util.Optional;
import java.util.Set;

public interface UzytkownikService {

    //tworzenie uzytkownika

    public Uzytkownik stworzUzytkownik(Uzytkownik uzytkownik, Set<UzytkownikRola> UzytkownikRole) throws Exception;

    //znajdz uzytkownika po emailu

    public Uzytkownik getUzytkownik(String email);

    //znajdz uzytkownika po id

    public Optional<Uzytkownik> findUzytkownik(Long idUzytkownik);

    //usun uzytkownika po id

    public void usunUzytkownik(Long idUzytkownik);
}
=======
package com.zeto.rezerwacja.service;

import com.zeto.rezerwacja.model.Uzytkownik;
import com.zeto.rezerwacja.model.UzytkownikRola;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface UzytkownikService {

    //tworzenie uzytkownika

    public Uzytkownik stworzUzytkownik(Uzytkownik uzytkownik, Set<UzytkownikRola> UzytkownikRole) throws Exception;

    //znajdz uzytkownika po emailu

    public Uzytkownik getUzytkownik(String email);

    //znajdz uzytkownika po id

    public Optional<Uzytkownik> findUzytkownik(Long idUzytkownik);

    //usun uzytkownika po id

    public void usunUzytkownik(Long idUzytkownik);
}
>>>>>>> main
