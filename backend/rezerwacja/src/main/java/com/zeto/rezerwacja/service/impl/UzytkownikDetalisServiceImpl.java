package com.zeto.rezerwacja.service.impl;

import com.zeto.rezerwacja.model.Uzytkownik;
import com.zeto.rezerwacja.repo.UzytkownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UzytkownikDetalisServiceImpl implements UserDetailsService {

    @Autowired
    private UzytkownikRepository uzytkownikRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

       Uzytkownik uzytkownik = this.uzytkownikRepository.findByEmail(email);
        if(uzytkownik==null)
        {
            System.out.println("Uzytkownik nie znaleziony!");
            throw new UsernameNotFoundException("Nie znaleziono uzytkownika!");
        }

        return uzytkownik;
    }
}
