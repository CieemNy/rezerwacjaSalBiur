package com.zeto.rezerwacja.domain;

import java.util.Date;

public class PomieszczenieRezerwacja {
    private long idPomieszczenie;
    private long idUzytkownik;
    private String nazwa;
    private String typ;
    private String imie;
    private String nazwisko;
    private Date date;


    public long getIdPomieszczenie() {
        return idPomieszczenie;
    }
    public void setIdPomieszczenie(long idPomieszczenie) {
        this.idPomieszczenie = idPomieszczenie;
    }
    public long getIdUzytkownik() {
        return idUzytkownik;
    }
    public void setIdUzytkownik(long idUzytkownik) {
        this.idUzytkownik = idUzytkownik;
    }
    public String getNazwa() {
        return nazwa;
    }
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    public String getTyp() {
        return typ;
    }
    public void setTyp(String typ) {
        this.typ = typ;
    }
    public String getImie() {
        return imie;
    }
    public void setImie(String imie) {
        this.imie = imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }



}
