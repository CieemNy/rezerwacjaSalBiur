package com.zeto.rezerwacja.service.impl;

import com.zeto.rezerwacja.model.Uzytkownik;
import com.zeto.rezerwacja.model.UzytkownikRola;
import com.zeto.rezerwacja.repo.RolaRepository;
import com.zeto.rezerwacja.repo.UzytkownikRepository;
import com.zeto.rezerwacja.service.UzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UzytkownikServiceImpl implements UzytkownikService {


    @Autowired
    private UzytkownikRepository uzytkownikRepository;

    @Autowired
    private RolaRepository rolaRepository;

    //tworzenie uzytkownika
    @Override
    public Uzytkownik stworzUzytkownik(Uzytkownik uzytkownik, Set<UzytkownikRola> UzytkownikRole) throws Exception {

        Uzytkownik local = this.uzytkownikRepository.findByEmail(uzytkownik.getEmail());
        if(local!=null){
            System.out.println("Użytkownik o takim emailu istnieje!");
            throw new Exception("Email jest w bazie!");
        }else
            //stworz uzytkownika
            for(UzytkownikRola ur:UzytkownikRole){
                rolaRepository.save(ur.getRola());
            }

            uzytkownik.getUzytkownikRole().addAll(UzytkownikRole);
            local = this.uzytkownikRepository.save(uzytkownik);

        return local;
    }

    //znajdz uzytkownika po emailu
    @Override
    public Uzytkownik getUzytkownik(String email) {
        return this.uzytkownikRepository.findByEmail(email);
    }

    @Override
    public Optional<Uzytkownik> findUzytkownik(Long idUzytkownik) {
        return this.uzytkownikRepository.findById(idUzytkownik);
    }

    @Override
    public void usunUzytkownik(Long idUzytkownik) {
        this.uzytkownikRepository.deleteById(idUzytkownik);
    }
}
