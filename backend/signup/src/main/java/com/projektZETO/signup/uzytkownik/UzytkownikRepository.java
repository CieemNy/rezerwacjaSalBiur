package com.projektZETO.signup.uzytkownik;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Repository
@Transactional(readOnly = true)
public interface UzytkownikRepository
        extends CrudRepository<Uzytkownik, Long> {
    Optional<Uzytkownik> findByEmail(String adresEmail);

    @Transactional
    @Modifying
    @Query("UPDATE Uzytkownik a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableUzytkownik(String email);
}
