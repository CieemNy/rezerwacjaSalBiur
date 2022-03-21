package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Uzytkownik implements UzytkownikDetails {
    @Id
    @GeneratedValue
    @Column(
            name = "idUzytkownik",
            updatable = false
    )
    private Long idUzytkownik;

    @Column(
            name = "imie",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String imie;

    @Column(
            name = "nazwisko",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nazwisko;

    @Column(
            name = "adresEmail",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String adresEmail;

    @Column(
            name = "haslo",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String haslo;

    @Column(
            name = "nrTelefonu",
            nullable = false
    )
    private String nrTelefonu;

    @Column(
            name = "idRola",
            nullable = false
    )
    private Integer  idRola;
    public Uzytkownik(String imie,
                      String nazwisko,
                      String adresEmail,
                      String haslo,
                      String nrTelefonu,
                      Integer idRola)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adresEmail = adresEmail;
        this.haslo = haslo;
        this.nrTelefonu = nrTelefonu;
        this.idRola = idRola;
    }

    public Long getidUzytkownik() {
        return idUzytkownik;
    }
    public void setidUzytkownik(Long idUzytkownik) {
        this.idUzytkownik = idUzytkownik;
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

    public String getAdresEmail() {
        return adresEmail;
    }

    public void setAdresEmail(String adresEmail) {
        this.adresEmail = adresEmail;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    public Integer getIdRola() {
        return idRola;
    }

    public void setIdRola(Integer idRola) {
        this.idRola = idRola;
    }

    @Override
    public String toString() {
        return "Uzytkownik{" +
                "idUzytkownik=" + idUzytkownik +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", adresEmail='" + adresEmail + '\'' +
                ", haslo='" + haslo + '\'' +
                ", nrTelefonu='" + nrTelefonu + '\'' +
                ", idRola=" + idRola +
                '}';
    }
}