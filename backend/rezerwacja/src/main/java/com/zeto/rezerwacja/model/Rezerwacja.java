package com.zeto.rezerwacja.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="Rezerwacja")
public class Rezerwacja {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idRezerwacja")
    private long idRezerwacja;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPomieszczenie", referencedColumnName = "idPomieszczenie")
    private Pomieszczenie idPomieszczenie;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUzytkownik", referencedColumnName = "idUzytkownik")
    private Uzytkownik idUzytkownik;

    @Column(name="dataStart")
    private Date dataStart;
    @Column(name="dataStop")
    private Date dataStop;

    public long getIdRezerwacja() {
        return idRezerwacja;
    }

    public void setIdRezerwacja(long idRezerwacja) {
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

    public Date getDataStart() {
        return dataStart;
    }

    public void setDataStart(Date dataStart) {
        this.dataStart = dataStart;
    }

    public Date getDataStop() {
        return dataStop;
    }

    public void setDataStop(Date dataStop) {
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
}