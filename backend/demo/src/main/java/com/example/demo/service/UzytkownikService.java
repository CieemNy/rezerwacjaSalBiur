package com.example.demo.service;

import com.example.demo.Uzytkownik;
import com.example.demo.repository.UzytkownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UzytkownikService implements IUzytkownikService{
    @Autowired
    private UzytkownikRepository uzytkownikRepository;
    public Uzytkownik saveUzytkownik(Uzytkownik uzytkownik)
    {
        return uzytkownikRepository.save(uzytkownik);
    }
    public Uzytkownik findBylogin(String login)
    {
        return uzytkownikRepository.findBylogin(login).orElse(null);
    }
    public List<Uzytkownik> findAll()
    {
        return uzytkownikRepository.findAll();
    }

}
