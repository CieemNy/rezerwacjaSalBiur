package com.example.demo.repository;

import com.example.demo.Uzytkownik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UzytkownikRepository extends JpaRepository<Uzytkownik, Long> {
    Optional<Uzytkownik> findBylogin(String login);
}
