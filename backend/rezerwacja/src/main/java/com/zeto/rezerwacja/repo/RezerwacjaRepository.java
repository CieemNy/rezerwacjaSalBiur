package com.zeto.rezerwacja.repo;

import com.zeto.rezerwacja.model.Rezerwacja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RezerwacjaRepository extends JpaRepository<Rezerwacja, Long> {

}
