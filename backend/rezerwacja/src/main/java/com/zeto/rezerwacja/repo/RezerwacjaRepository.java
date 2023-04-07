package com.zeto.rezerwacja.repo;

import com.zeto.rezerwacja.model.Rezerwacja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface RezerwacjaRepository extends CrudRepository<Rezerwacja, Long> {
    List<Rezerwacja> findByDate(Date date);

    List<Rezerwacja> findAll();
}