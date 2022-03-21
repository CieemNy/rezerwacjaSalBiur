package com.projektZETO.signup.uzytkownik;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UzytkownikRepository
        extends JpaRepository<Uzytkownik,Long> {
    Optional<Uzytkownik> findByEmail(String adresEmail);
}
