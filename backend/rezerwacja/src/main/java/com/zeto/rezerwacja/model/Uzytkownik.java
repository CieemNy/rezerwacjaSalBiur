package com.zeto.rezerwacja.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "uzytkownicy")
public class Uzytkownik {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String imie;
    private String nazwisko;
    private String email;
    private String haslo;
    private String telefon;

    // uzytkownik ma wiele rol
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "uzytkownik")
    @JsonIgnore
    private Set<UzytkownikRola> UzytkownikRole=new HashSet<>();



    public Uzytkownik() {

    }

    public Set<UzytkownikRola> getUzytkownikRole() {
        return UzytkownikRole;
    }

    public void setUzytkownikRole(Set<UzytkownikRola> uzytkownikRole) {
        UzytkownikRole = uzytkownikRole;
    }

    public Uzytkownik(Long id, String login, String imie, String nazwisko, String email, String haslo, String telefon) {
        this.id = id;
        this.login = login;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.haslo = haslo;
        this.telefon = telefon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
