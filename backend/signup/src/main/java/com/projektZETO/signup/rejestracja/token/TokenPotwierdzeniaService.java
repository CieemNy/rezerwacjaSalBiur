package com.projektZETO.signup.rejestracja.token;

import antlr.Token;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor

public class TokenPotwierdzeniaService {

    private final TokenPotwierdzeniaRepository tokenPotwierdzeniaRepository;

    public void zapiszTokenPotwierdzenia(TokenPotwierdzenia token){
        tokenPotwierdzeniaRepository.save(token);
    }
    public  Optional<TokenPotwierdzenia> getToken(String token) { return tokenPotwierdzeniaRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return tokenPotwierdzeniaRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }

}
