package com.zeto.rezerwacja.service.impl;

import com.zeto.rezerwacja.model.Pomieszczenie;
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
    public Pomieszczenie getPomieszczenie(String nazwa){
        return this.pomieszczenieRepository.findByNazwa(nazwa);
    }

    @Override
    public List<Pomieszczenie> getTypPomieszczenie(String typ) {
        List<Pomieszczenie> lista = new ArrayList<>();
        for(Pomieszczenie pom: pomieszczenieRepository.findAll()){
            if(pom.getTyp() == typ)
            {
                lista.add(pom);
            }
        }
        return lista;
    }

    @Override
    public Optional<Pomieszczenie> findPomieszczenie(Long idPomieszczenie){
        return this.pomieszczenieRepository.findById(idPomieszczenie);
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