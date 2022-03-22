package com.projektZETO.signup.rejestracja.token;

import antlr.Token;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class TokenPotwierdzeniaService {

    private final TokenPotwierdzeniaRepository tokenPotwierdzeniaRepository;

    public void zapiszTokenPotwierdzenia(TokenPotwierdzenia token){
        tokenPotwierdzeniaRepository.save(token);
    }
}
