package com.zeto.rezerwacja.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name="Rezerwacja")
public class Rezerwacja {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}