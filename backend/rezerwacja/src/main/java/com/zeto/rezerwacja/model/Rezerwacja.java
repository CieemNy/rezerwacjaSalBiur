package com.zeto.rezerwacja.model;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name="Rezerwacja")
=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="REZERWACJA")
>>>>>>> main
public class Rezerwacja {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
<<<<<<< HEAD
    @Column(name="idRezerwacja")
    private Long idRezerwacja;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPomieszczenie", referencedColumnName = "idPomieszczenie")
    private Pomieszczenie idPomieszczenie;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUzytkownik")
    private Uzytkownik idUzytkownik;

    @Column(name="dataStart")
    private LocalDate dataStart;
    @Column(name="dataStop")
    private LocalDate dataStop;

    public Long getIdRezerwacja() {
        return idRezerwacja;
    }

    public void setIdRezerwacja(Long idRezerwacja) {
        this.idRezerwacja = idRezerwacja;
    }

    public Pomieszczenie getIdPomieszczenie() {
        return idPomieszczenie;
    }

    public void setIdPomieszczenie(Pomieszczenie idPomieszczenie) {
        this.idPomieszczenie = idPomieszczenie;
    }

    public Uzytkownik getIdUzytkownik() {
        return idUzytkownik;
    }

    public void setIdUzytkownik(Uzytkownik idUzytkownik) {
        this.idUzytkownik = idUzytkownik;
    }

    public LocalDate getDataStart() {
        return dataStart;
    }

    public void setDataStart(LocalDate dataStart) {
        this.dataStart = dataStart;
    }

    public LocalDate getDataStop() {
        return dataStop;
    }

    public void setDataStop(LocalDate dataStop) {
        this.dataStop = dataStop;
    }

    @Override
    public String toString() {
        return "Rezerwacja{" +
                "idRezerwacja=" + idRezerwacja +
                ", idPomieszczenie=" + idPomieszczenie +
                ", idUzytkownik=" + idUzytkownik +
                ", dataStart=" + dataStart +
                ", dataStop=" + dataStop +
                '}';
    }
    public Rezerwacja(){}
=======
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
>>>>>>> main
}