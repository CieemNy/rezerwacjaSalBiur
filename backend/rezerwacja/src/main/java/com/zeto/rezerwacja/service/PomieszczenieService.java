package com.zeto.rezerwacja.service;

import com.zeto.rezerwacja.model.Pomieszczenie;
import com.zeto.rezerwacja.repo.PomieszczenieRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;


public interface PomieszczenieService {

    public Pomieszczenie dodajPomieszczenie(Pomieszczenie pomieszczenie) throws Exception;

    public List<Pomieszczenie> getPomieszczenie(String nazwa);

    public List<Pomieszczenie> getTypPomieszczenie(String typ);

    public Pomieszczenie findPomieszczenie(Long idPomieszczenie);

    public void usunPomieszczenie(Long idPomieszczenie);

    public List<Pomieszczenie> getAllPomieszczenia();

}