package com.zeto.rezerwacja.repo;

import com.zeto.rezerwacja.model.Uzytkownik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UzytkownikRepository extends JpaRepository<Uzytkownik, Long> {

    public Uzytkownik findByEmail(String email);
}
