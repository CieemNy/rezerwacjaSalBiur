package com.zeto.rezerwacja.repo;

import com.zeto.rezerwacja.model.Pomieszczenie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PomieszczenieRepository extends JpaRepository<Pomieszczenie, Long> {

    public Pomieszczenie findByNazwa(String Nazwa);

    public Pomieszczenie findByTyp(String Typ);
}
