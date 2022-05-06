package com.zeto.rezerwacja.repo;

import com.zeto.rezerwacja.model.Rola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolaRepository extends JpaRepository<Rola, Long> {

}
