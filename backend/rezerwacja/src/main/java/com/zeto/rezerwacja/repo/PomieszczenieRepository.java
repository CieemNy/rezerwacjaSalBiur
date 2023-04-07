package com.zeto.rezerwacja.repo;

import com.zeto.rezerwacja.model.Pomieszczenie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PomieszczenieRepository extends CrudRepository<Pomieszczenie, Long>{
    Pomieszczenie findByNazwa(String nazwa);

    Iterable<Pomieszczenie> findAll();

}
