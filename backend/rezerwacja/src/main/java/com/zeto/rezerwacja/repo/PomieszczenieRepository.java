package com.zeto.rezerwacja.repo;

import com.zeto.rezerwacja.model.Pomieszczenie;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PomieszczenieRepository extends JpaRepository<Pomieszczenie, Long> {

    public Pomieszczenie findByNazwa(String Nazwa);

    public Pomieszczenie findByTyp(String Typ);
=======
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PomieszczenieRepository extends CrudRepository<Pomieszczenie, Long>{
    Pomieszczenie findByNazwa(String nazwa);

    Iterable<Pomieszczenie> findAll();

>>>>>>> main
}
