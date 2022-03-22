package com.projektZETO.signup.rejestracja;

import com.projektZETO.signup.rejestracja.token.TokenPotwierdzenia;
import com.projektZETO.signup.rejestracja.token.TokenPotwierdzeniaService;
import com.projektZETO.signup.uzytkownik.Uzytkownik;
import com.projektZETO.signup.uzytkownik.UzytkownikRola;
import com.projektZETO.signup.uzytkownik.UzytkownikService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RejestracjaService {

    private final UzytkownikService uzytkownikService;
    private final EmailValidator emailValidator;
    private final TokenPotwierdzeniaService tokenPotwierdzeniaService;
    public String rejestracja(RejestracjaRequest request) {

        boolean isValidEmail = emailValidator.
                test(request.getAdresEmail());
        if(!isValidEmail)
        {
            throw new IllegalStateException("email nieprawidlowy");
        }
        return uzytkownikService.rejestracjaUzytkownik(
                new Uzytkownik(
                        request.getImie(),
                        request.getNazwisko(),
                        request.getAdresEmail(),
                        request.getHaslo(),
                        request.getNrTelefonu(),
                        UzytkownikRola.KLIENT
                )
        );
    }
    @Transactional
    public String tokenPotwierdzenia(String token){
        TokenPotwierdzenia tokenPotwierdzenia = tokenPotwierdzeniaService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("Token nie znaleziony"));

        if (tokenPotwierdzenia.getConfirmedAt() != null){
            throw new IllegalStateException("Email jest już potwierdzony");
        }

        LocalDateTime expiredAt = tokenPotwierdzenia.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())){
            throw new IllegalStateException("Token wygasł");
        }
        tokenPotwierdzeniaService.setConfirmedAt(token);
        uzytkownikService.enableUzytkownik(
                tokenPotwierdzenia.getUzytkownik().getEmail());
        return "Potwierdzony";
    }
}
