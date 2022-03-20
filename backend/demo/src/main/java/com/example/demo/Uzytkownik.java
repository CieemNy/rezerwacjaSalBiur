package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class uzytkownik {
    @Id
    @GeneratedValue
    @Column(name = "idUzytkownik")
    private Integer idUzytkownik;
    @Column(name = "login")
    private String login;
    @Column(name = "imie")
    private String imie;
    @Column(name = "nazwisko")
    private String nazwisko;
    @Column(name = "adresEmail")
    private String adresEmail;
    @Column(name = "haslo")
    private String haslo;
    @Column(name = "nrTelefonu")
    private String nrTelefonu;
    @Column(name = "idRola")
    private Integer  idRola;

    public uzytkownik(Integer idUzytkownik,
                      String login,
                      String imie,
                      String nazwisko,
                      String adresEmail,
                      String haslo,
                      String nrTelefonu,
                      Integer idRola)
    {
        this.idUzytkownik = idUzytkownik;
        this.login = login;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adresEmail = adresEmail;
        this.haslo = haslo;
        this.nrTelefonu = nrTelefonu;
        this.idRola = idRola;
    }

    public Integer getidUzytkownik() {
        return idUzytkownik;
    }

    public void setidUzytkownik(Integer idUzytkownik) {
        this.idUzytkownik = idUzytkownik;
    }

    public String   getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
        return "uzytkownik{" +
                "idUzytkownik=" + idUzytkownik +
                ", login='" + login + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", adresEmail='" + adresEmail + '\'' +
                ", haslo='" + haslo + '\'' +
                ", nrTelefonu='" + nrTelefonu + '\'' +
                ", idRola=" + idRola +
                '}';
    }
}