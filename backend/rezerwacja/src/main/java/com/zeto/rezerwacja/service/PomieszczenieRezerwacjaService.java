package com.zeto.rezerwacja.service;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeto.rezerwacja.domain.PomieszczenieRezerwacja;
import com.zeto.rezerwacja.model.*;
import com.zeto.rezerwacja.repo.*;

@Service
public class PomieszczenieRezerwacjaService {

    private Uzytkownik uzytkownik;
    private PomieszczenieRepository pomieszczenieRepository;
    private UzytkownikRepository uzytkownikRepository;
    private RezerwacjaRepository rezerwacjaRepository;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public PomieszczenieRezerwacjaService(PomieszczenieRepository pomieszczenieRepository, UzytkownikRepository uzytkownikRepository,
                                          RezerwacjaRepository rezerwacjaRepository, Uzytkownik uzytkownik) {
        this.pomieszczenieRepository = pomieszczenieRepository;
        this.uzytkownikRepository = uzytkownikRepository;
        this.rezerwacjaRepository = rezerwacjaRepository;
        this.uzytkownik = uzytkownik;

    }

    public List<PomieszczenieRezerwacja> getPomieszczenieRezerwacjeForDate(String dateString) {
        Date date = createDateFromDateString(dateString);
        Map<Long, PomieszczenieRezerwacja> pomieszczenieRezerwacjaMap = new HashMap<>();

        Iterable<Pomieszczenie> pomieszczenia = this.pomieszczenieRepository.findAll();
        pomieszczenia.forEach(pomieszczenie -> {
            PomieszczenieRezerwacja pomieszczenieRezerwacja = new PomieszczenieRezerwacja();
            pomieszczenieRezerwacja.setIdPomieszczenie(pomieszczenie.getIdPomieszczenie());
            pomieszczenieRezerwacja.setNazwa(pomieszczenie.getNazwa());
            pomieszczenieRezerwacja.setTyp(pomieszczenie.getTyp());
            pomieszczenieRezerwacjaMap.put(pomieszczenie.getIdPomieszczenie(), pomieszczenieRezerwacja);
        });

        Iterable<Rezerwacja> rezerwacje = this.rezerwacjaRepository.findByDate(new java.sql.Date(date.getTime()));
        if (rezerwacje != null) {

            rezerwacje.forEach(rezerwacja -> {
                Uzytkownik uzytkownik1 = this.uzytkownikRepository.findByEmail(uzytkownik.getEmail());
                if (uzytkownik1 != null) {
                    PomieszczenieRezerwacja pomieszczenieRezerwacja = pomieszczenieRezerwacjaMap.get(rezerwacja.getIdPomieszczenie());
                    pomieszczenieRezerwacja.setIdUzytkownik(uzytkownik.getIdUzytkownik());
                    pomieszczenieRezerwacja.setImie(uzytkownik.getImie());
                    pomieszczenieRezerwacja.setNazwisko(uzytkownik.getNazwisko());
                    pomieszczenieRezerwacja.setDate(new java.sql.Date(date.getTime()));
                }
            });
        }

        List<PomieszczenieRezerwacja> pomieszczenieRezerwacje = new ArrayList<>();
        for (Long roomId : pomieszczenieRezerwacjaMap.keySet()) {
            pomieszczenieRezerwacje.add(pomieszczenieRezerwacjaMap.get(roomId));
        }
        return pomieszczenieRezerwacje;
    }

    private Date createDateFromDateString(String dateString) {

        Date date = null;
        if(null != dateString) {
            try {
                date = DATE_FORMAT.parse(dateString);
            }catch (ParseException pe) {
                date = new Date();
            }
        } else {
            date = new Date();
        }

        return date;
    }
}