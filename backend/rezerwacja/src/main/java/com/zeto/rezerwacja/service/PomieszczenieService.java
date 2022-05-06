package com.zeto.rezerwacja.service;

import com.zeto.rezerwacja.model.Pomieszczenie;


import java.util.Optional;


public interface PomieszczenieService {

    public Pomieszczenie dodajPomieszczenie(Pomieszczenie pomieszczenie) throws Exception;

    public Pomieszczenie getPomieszczenie(String nazwa);

    public Optional<Pomieszczenie> findPomieszczenie(Long idPomieszczenie);

    public void usunPomieszczenie(Long idPomieszczenie);

}
