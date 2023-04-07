package com.zeto.rezerwacja.repo;

import com.zeto.rezerwacja.model.Rezerwacja;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RezerwacjaRepository extends JpaRepository<Rezerwacja, Long> {

    public Rezerwacja findByIdPomieszczenie(Long idPomieszczenie);

    public Rezerwacja findByIdUzytkownik(Long idUzytkownik);
}
=======
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface RezerwacjaRepository extends CrudRepository<Rezerwacja, Long> {
    List<Rezerwacja> findByDate(Date date);

    List<Rezerwacja> findAll();
}
>>>>>>> main
