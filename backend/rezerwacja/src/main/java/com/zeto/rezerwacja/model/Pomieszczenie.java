package com.zeto.rezerwacja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="POMIESZCZENIE")
public class Pomieszczenie {
    @Id
    @Column(name = "POMIESZCZENIE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPomieszczenie;
    @Column(name = "NAZWA")
    private String nazwa;
    @Column(name = "TYP_POMIESZCZENIA")
    private String typ;
    @Column(name = "ULICA")
    private String ulica;
    @Column(name = "MIASTO")
    private String miasto;
    @Column(name = "KOD_POCZTOWY")
    private String kodPocztowy;
    @Column(name = "ID_GALERII")
    private String idGalerii;

    public long getIdPomieszczenie() {
        return idPomieszczenie;
    }

    public void setIdPomieszczenie(long idPomieszczenie) {
        this.idPomieszczenie = idPomieszczenie;
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

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getIdGalerii() {
        return idGalerii;
    }

    public void setIdGalerii(String idGalerii) {
        this.idGalerii = idGalerii;
    }
}