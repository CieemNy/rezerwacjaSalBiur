package com.zeto.rezerwacja.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class UzytkownikRola {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uzytkownikRolaId;

    //uzytkownik
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUzytkownik")

    private Uzytkownik uzytkownik;

    @ManyToOne
    @JsonIgnore
    private Rola rola;

    public UzytkownikRola() {
    }

    public Long getUzytkownikRolaId() {
        return uzytkownikRolaId;
    }

    public void setUzytkownikRolaId(Long uzytkownikRolaId) {
        this.uzytkownikRolaId = uzytkownikRolaId;
    }

    public Uzytkownik getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(Uzytkownik uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public Rola getRola() {
        return rola;
    }

    public void setRola(Rola rola) {
        this.rola = rola;
    }
}
