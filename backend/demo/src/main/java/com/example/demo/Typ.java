package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Typ")

public class Typ {
    @Id
    private Integer idTyp;
    private String nazwa;

    public Typ(Integer idTyp, String nazwa) {
        this.idTyp = idTyp;
        this.nazwa = nazwa;
    }

    public Integer getIdTyp() {
        return idTyp;
    }

    public void setIdTyp(Integer idTyp) {
        this.idTyp = idTyp;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Typ{" +
                "idTyp=" + idTyp +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
