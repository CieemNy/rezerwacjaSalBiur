package com.zeto.rezerwacja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="REZERWACJA")
public class Rezerwacja {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="REZERWACJA_ID")
    private long idRezerwacja;
    @Column(name="POMIESZCZENIE_ID")
    private long idPomieszczenie;
    @Column(name="Uzytkownik_ID")
    private long idUzytkownik;
    @Column(name="RES_DATE")
    private Date date;

    public long getIdRezerwacja() {
        return idRezerwacja;
    }

    public void setIdRezerwacja(long idRezerwacja) {
        this.idRezerwacja = idRezerwacja;
    }

    public long getIdPomieszczenie() {
        return idPomieszczenie;
    }

    public void setIdPomieszczenie(long IdPomieszczenie) {
        this.idPomieszczenie = idPomieszczenie;
    }

    public long getIdUzytkownik() {
        return idUzytkownik;
    }

    public void setIdUzytkownik(long IdUzytkownik) {
        this.idUzytkownik = idUzytkownik;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}