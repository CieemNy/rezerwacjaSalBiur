package com.projektZETO.signup.rejestracja.token;

import antlr.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenPotwierdzeniaRepository
        extends JpaRepository<TokenPotwierdzenia, Long> {

    Optional<TokenPotwierdzenia> findByToken(String token);

}



