package com.zeto.rezerwacja.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name="pomieszczenie")
public class Pomieszczenie {
    @Id
    @Column(name = "idPomieszczenie")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "WOJEWODZTWO")
    private String wojewodztwo;

    @Column(name = "NUMER")
    private String numer;

    @Column(name = "OPIS")
    private String opis;

    public String getNumer() {
        return numer;
    }

    public void setNumer(String numer) {
        this.numer = numer;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getWojewodztwo() {
        return wojewodztwo;
    }

    public void setWojewodztwo(String wojewodztwo) {
        this.wojewodztwo = wojewodztwo;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idGalerii",columnDefinition = "integer default null", referencedColumnName = "id")
    private ImageGallery idGalerii;

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

    public ImageGallery getIdGalerii() {
        return idGalerii;
    }

    public void setIdGalerii(ImageGallery idGalerii) {
        this.idGalerii = idGalerii;
    }

    public Pomieszczenie(){}

    @Override
    public String toString() {
        return "Pomieszczenie{" +
                "idPomieszczenie=" + idPomieszczenie +
                ", nazwa='" + nazwa + '\'' +
                ", typ='" + typ + '\'' +
                ", ulica='" + ulica + '\'' +
                ", miasto='" + miasto + '\'' +
                ", kodPocztowy='" + kodPocztowy + '\'' +
                ", wojewodztwo='" + wojewodztwo + '\'' +
                ", numer='" + numer + '\'' +
                ", opis='" + opis + '\'' +
                ", idGalerii=" + idGalerii +
                '}';
    }
}