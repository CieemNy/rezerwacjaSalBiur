package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Rola")

public class Rola {
    @Id
    private Integer idrola;
    private String nazwa;

    public Rola(Integer idrola, String nazwa) {
        this.idrola = idrola;
        this.nazwa = nazwa;
    }

    public Integer getIdrola() {
        return idrola;
    }

    public void setIdrola(Integer idrola) {
        this.idrola = idrola;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Rola{" +
                "idrola=" + idrola +
                ", nazwa=" + nazwa +
                '}';
    }
}
